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
import br.com.cavsystem.dominio.converter.MoradorConverter;
import br.com.cavsystem.dominio.entity.dto.MoradorDTO;
import br.com.cavsystem.exception.BusinessException;
import br.com.cavsystem.service.GeradorRelatorioService;
import br.com.cavsystem.service.MoradorService;
import br.com.cavsystem.util.ConstantesArchive;

@RestController
@RequestMapping("morador")
public class MoradorControllerRest extends RestBase<MoradorDTO, Long>  {
	
	@Autowired
	private MoradorService service;	
	
	@Autowired
	private MoradorConverter converter;
	
	@Autowired
	private GeradorRelatorioService relatorio;
	
	@Autowired
	private ServletContext servletContext;

	@Override
	protected MoradorDTO acaoObter(Long id) throws BusinessException {
		return converter.convertToDTO(service.obter(id));
	}

	@Override
	protected List<MoradorDTO> acaoListar() {
		return null;
	}

	@Override
	protected MoradorDTO acaoIncluir(MoradorDTO t) throws BusinessException {
		return converter.convertToDTO(service.incluir(converter.convertToEntity(t)));
	}

	@Override
	protected MoradorDTO acaoAtualizar(MoradorDTO t) throws BusinessException {
		return converter.convertToDTO(service.alterar(converter.convertToEntity(t)));
	}

	@Override
	protected void acaoRemover(Long id) throws BusinessException {
					service.excluir(id);		
	}

	@RequestMapping(value="/moradorPorCondominio/{id}" , method=RequestMethod.GET)
	public List<MoradorDTO> listarMoradorPorCondominio(@PathVariable Long id){
		return converter.convertToDTO(service.moradorPorCondominio(id));
	}
	
	@RequestMapping(value="/moradorPorApartamento/{id}" , method=RequestMethod.GET)
	public List<MoradorDTO> listarMoradorPorApartamento(@PathVariable Long id){
		return converter.convertToDTO(service.moradorPorApartamento(id));
	}
	
	
	 @RequestMapping(method = RequestMethod.GET, value = "/relatorioMoradores")
	   	public void imprimirRequisicaoMorador(
	   			@RequestParam(required = true, value = "id_condominio") Long id_condominio, 
	   			@RequestParam(required = false, value = "usuario") String usuario,
	   			@RequestParam(required = false, value = "condominio") String condominio,
	   			HttpServletResponse response) throws IOException, BusinessException {	
	    	
		 byte[] documentBody = null;
	    	OutputStream outputStream = null;
	       	try {
	       		documentBody = relatorio.gerarRelatorioMorador(service.moradorPorCondominio(id_condominio), servletContext.getRealPath("/relatorios/"),usuario,condominio);
	       		outputStream = response.getOutputStream();
	       		response.setContentType(ConstantesArchive.PDF_MIME_TYPE);
	       		response.setHeader("Content-Disposition", "inline; filename=MORADORES" + ConstantesArchive.EXTENSAO_PDF);
	       		response.setHeader("Content-Length", String.valueOf(documentBody.length));

	       		IOUtils.write(documentBody, outputStream);
	       	} catch(IOException e){
	       		System.out.println(e.getMessage());
	       	} 
	       	
	       	finally {
	       		IOUtils.closeQuietly(outputStream);
	       	}
	    }
	 
}
