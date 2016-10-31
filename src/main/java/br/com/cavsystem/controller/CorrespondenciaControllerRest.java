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

import br.com.cavsystem.dominio.converter.CorrespondenciaConverter;
import br.com.cavsystem.dominio.entity.dto.CorrespondeciaDTO;
import br.com.cavsystem.dominio.enums.SimNaoEnum;
import br.com.cavsystem.exception.BusinessException;
import br.com.cavsystem.service.CorrespondenciaService;
import br.com.cavsystem.service.GeradorRelatorioService;
import br.com.cavsystem.util.ConstantesArchive;


@RestController
@RequestMapping("correspondencia")
public class CorrespondenciaControllerRest extends RestBase<CorrespondeciaDTO, Long>  {
	
	@Autowired
	private CorrespondenciaService service;
	
	@Autowired
	private CorrespondenciaConverter converter;
	
	@Autowired
	private GeradorRelatorioService relatorio;
	
	@Autowired
	private ServletContext servletContext;
	
	@Override
	protected CorrespondeciaDTO acaoObter(Long id) throws BusinessException {
		return null;
	}

	@Override
	protected List<CorrespondeciaDTO> acaoListar() {
		// TODO Auto-generated method stub
		return null;
	}

	@RequestMapping(value="/incluirLista", method=RequestMethod.POST)
	protected void acaoIncluirLista(@RequestBody List<CorrespondeciaDTO> t)
			throws BusinessException {		
		service.incluirLista(converter.convertToEntity(t));
	}
	
	@RequestMapping(value="/alterarLista", method=RequestMethod.PUT)
	protected void acaoAlterarLista(@RequestBody List<CorrespondeciaDTO> t)
			throws BusinessException {		
		service.alterarLista(converter.convertToEntity(t));
	}

	@Override
	protected CorrespondeciaDTO acaoAtualizar(CorrespondeciaDTO t)
			throws BusinessException {
		return converter.convertToDTO(service.alterar(converter.convertToEntity(t)));
	}

	@Override
	protected void acaoRemover(Long id) throws BusinessException {
		// TODO Auto-generated method stub		
	}

	@RequestMapping(value="/buscaPorApartamento/{id}/{liberado}", method=RequestMethod.GET)
	public ResponseEntity<List<CorrespondeciaDTO>> buscaPorApartamento(@PathVariable Long id, @PathVariable SimNaoEnum liberado) throws BusinessException {
		return new ResponseEntity<List<CorrespondeciaDTO>>(converter.convertToDTO(service.listaPorApartamento(id,liberado)),HttpStatus.OK);
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/buscaPorCondominioDataInicioDataFim/{id}/{inicio}/{fim}/{liberado}")
   	public ResponseEntity<List<CorrespondeciaDTO>> buscaPorCondominioDataInicioDataFim(@PathVariable Long id,@PathVariable Date inicio,@PathVariable Date fim, @PathVariable SimNaoEnum liberado){
	List<CorrespondeciaDTO> dtos = converter.convertToDTO(service.listaPorCondominioData(id, inicio, fim, liberado));
	return new ResponseEntity<List<CorrespondeciaDTO>>(dtos,HttpStatus.OK);
	}

	@Override
	protected CorrespondeciaDTO acaoIncluir(CorrespondeciaDTO t)
			throws BusinessException {
		return null;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/relatorioCorrespondecia")
   	public void imprimirCoorespondencias(
   			@RequestParam(required = true, value = "id_condominio") Long id_condominio, 
   			@RequestParam(required = false, value = "usuario") String usuario,
   			@RequestParam(required = false, value = "condominio") String condominio,
   			@RequestParam(required = false, value = "inicio") Date inicio,
   			@RequestParam(required = false, value = "fim") Date fim,
   			@RequestParam(required = false, value = "liberado") SimNaoEnum liberado,   			
   			HttpServletResponse response) throws IOException, BusinessException {	
    	
	 byte[] documentBody = null;
    	OutputStream outputStream = null;
       	try {
       		documentBody = relatorio.gerarRelatorioCorrespondencias(service.listaPorCondominioData(id_condominio, inicio, fim, liberado), servletContext.getRealPath("/relatorios/"),usuario,condominio);
       		outputStream = response.getOutputStream();
       		response.setContentType(ConstantesArchive.PDF_MIME_TYPE);
       		response.setHeader("Content-Disposition", "inline; filename=CORRESPONDENCIA" + ConstantesArchive.EXTENSAO_PDF);
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
