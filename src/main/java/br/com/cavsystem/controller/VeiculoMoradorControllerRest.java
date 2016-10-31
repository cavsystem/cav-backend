package br.com.cavsystem.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.cavsystem.dominio.converter.VeiculoMoradorConverter;
import br.com.cavsystem.dominio.entity.dto.VeiculoMoradorDTO;
import br.com.cavsystem.exception.BusinessException;
import br.com.cavsystem.service.GeradorRelatorioService;
import br.com.cavsystem.service.VeiculoMoradorService;
import br.com.cavsystem.util.ConstantesArchive;

@RestController
@RequestMapping("veiculoMorador")
public class VeiculoMoradorControllerRest extends RestBase<VeiculoMoradorDTO, Long>  {
	
	@Autowired
	private VeiculoMoradorService service;
	
	@Autowired
	private VeiculoMoradorConverter converter;
	
	@Autowired
	private GeradorRelatorioService relatorio;
	
	@Autowired
	private ServletContext servletContext;
	

	@RequestMapping(value="/veiculoMoradorPorCondominio/{id}" , method=RequestMethod.GET)
	public List<VeiculoMoradorDTO> listarVeiculoMoradorPorCondominio(@PathVariable Long id){
		return converter.convertToDTO(service.veiculoMoradorPorCondominio(id));
	}
	
	@RequestMapping(value="/veiculoMoradorPorMorador/{id}" , method=RequestMethod.GET)
	public List<VeiculoMoradorDTO> listarVeiculoMoradorPorMorador(@PathVariable Long id){
		return converter.convertToDTO(service.veiculoMoradorPorMorador(id));
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/relatorioVeiculos")
   	public void imprimirVeiculos(
   			@RequestParam(required = true, value = "id_condominio") Long id_condominio, 
   			@RequestParam(required = false, value = "usuario") String usuario,
   			@RequestParam(required = false, value = "condominio") String condominio,
   			HttpServletResponse response) throws IOException, BusinessException {	
    	
	 byte[] documentBody = null;
    	OutputStream outputStream = null;
       	try {
       		documentBody = relatorio.gerarRelatorioVeiculoMorador(service.veiculoMoradorPorCondominio(id_condominio), servletContext.getRealPath("/relatorios/"),usuario,condominio);
       		outputStream = response.getOutputStream();
       		response.setContentType(ConstantesArchive.PDF_MIME_TYPE);
       		response.setHeader("Content-Disposition", "inline; filename=VEICULOS" + ConstantesArchive.EXTENSAO_PDF);
       		response.setHeader("Content-Length", String.valueOf(documentBody.length));

       		IOUtils.write(documentBody, outputStream);
       	} catch(IOException e){
       		System.out.println(e.getMessage());
       	} 
       	
       	finally {
       		IOUtils.closeQuietly(outputStream);
       	}
    }


	@Override
	protected void acaoRemover(Long id) throws BusinessException {
		service.excluir(id);		
	}

	@Override
	protected VeiculoMoradorDTO acaoObter(Long id) throws BusinessException {
		return converter.convertToDTO(service.obter(id));
	}

	@Override
	protected List<VeiculoMoradorDTO> acaoListar() {
		return null;
	}

	@Override
	protected VeiculoMoradorDTO acaoIncluir(VeiculoMoradorDTO t)
			throws BusinessException {
		return converter.convertToDTO(service.incluir(converter.convertToEntity(t)));
	}

	@Override
	protected VeiculoMoradorDTO acaoAtualizar(VeiculoMoradorDTO t)
			throws BusinessException {
		return converter.convertToDTO(service.alterar(converter.convertToEntity(t)));
	}
	
	
}
