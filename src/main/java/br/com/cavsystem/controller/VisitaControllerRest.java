package br.com.cavsystem.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.cavsystem.dominio.converter.VisitaConverter;
import br.com.cavsystem.dominio.entity.dto.VisitaDTO;
import br.com.cavsystem.dominio.enums.AtivoInativoEnum;
import br.com.cavsystem.exception.BusinessException;
import br.com.cavsystem.service.GeradorRelatorioService;
import br.com.cavsystem.service.VisitaService;
import br.com.cavsystem.util.ConstantesArchive;

@RestController
@RequestMapping("visita")
public class VisitaControllerRest extends RestBase<VisitaDTO, Long>  {

	@Autowired
	private VisitaService service;
	
	@Autowired
	private VisitaConverter converter;
	
	@Autowired
	private GeradorRelatorioService relatorio;
	
	@Autowired
	private ServletContext servletContext;


	@Override
	protected VisitaDTO acaoObter(Long id) throws BusinessException {
		return converter.convertToDTO(service.obter(id));
	}

	@Override
	protected List<VisitaDTO> acaoListar() {
		return null;
	}

	@Override
	protected VisitaDTO acaoIncluir(VisitaDTO t) throws BusinessException {
		return converter.convertToDTO(service.incluir(converter.convertToEntity(t)));
	}

	@Override
	protected VisitaDTO acaoAtualizar(VisitaDTO t) throws BusinessException {
		return converter.convertToDTO(service.alterar(converter.convertToEntity(t)));
	}

	@Override
	protected void acaoRemover(Long id) throws BusinessException {
		service.excluir(id);		
	}
	
	@RequestMapping(value="/buscarPorCondominioData/{id}/{inicio}/{fim}/{ativo}", method=RequestMethod.GET)
	public ResponseEntity<List<VisitaDTO>> buscaVisitantePorCpf(@PathVariable Long id,@PathVariable Date inicio,@PathVariable Date fim ,@PathVariable AtivoInativoEnum ativo) throws BusinessException{			
		List<VisitaDTO> dto = converter.convertToDTO(service.listaPorCondominioData(id,inicio,fim, ativo));		
		return new ResponseEntity<List<VisitaDTO>>(dto,HttpStatus.OK);
	}
	
	@RequestMapping(value="/buscarPorCondominio/{id}/{ativo}", method=RequestMethod.GET)
	public ResponseEntity<List<VisitaDTO>> buscaVisitantePorCpf(@PathVariable Long id, @PathVariable AtivoInativoEnum ativo) throws BusinessException{			
		List<VisitaDTO> dto = converter.convertToDTO(service.buscaVisitaPorCondominio(id, ativo));		
		return new ResponseEntity<List<VisitaDTO>>(dto,HttpStatus.OK);
	}
	
	@RequestMapping(value="/finalizar", method=RequestMethod.PUT)
	public VisitaDTO finalizarVisitas(@RequestBody VisitaDTO visita) throws BusinessException {
		return converter.convertToDTO(service.finalizarVisitas(converter.convertToEntity(visita)));
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/relatorioVisitas")
   	public void imprimirRequisicaoVisitas(
   			@RequestParam(required = true, value = "id_condominio") Long id_condominio, 
   			@RequestParam(required = false, value = "usuario") String usuario,
   			@RequestParam(required = false, value = "condominio") String condominio,
   			@RequestParam(required = false, value = "inicio") Date inicio,
   			@RequestParam(required = false, value = "fim") Date fim,
   			@RequestParam(required = false, value = "liberado") AtivoInativoEnum liberado, 
   			HttpServletResponse response) throws IOException, BusinessException {	
    	
	 byte[] documentBody = null;
    	OutputStream outputStream = null;
       	try {
       		documentBody = relatorio.gerarRelatorioVisitas(service.listaPorCondominioData(id_condominio, inicio, fim, liberado), servletContext.getRealPath("/relatorios/"),usuario,condominio);
       		outputStream = response.getOutputStream();
       		response.setContentType(ConstantesArchive.PDF_MIME_TYPE);
       		response.setHeader("Content-Disposition", "inline; filename=VISITAS" + ConstantesArchive.EXTENSAO_PDF);
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
