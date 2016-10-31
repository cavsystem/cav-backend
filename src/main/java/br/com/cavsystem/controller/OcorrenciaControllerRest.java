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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.cavsystem.dominio.converter.OcorrenciaConverter;
import br.com.cavsystem.dominio.converter.UsuarioConverter;
import br.com.cavsystem.dominio.entity.Ocorrencia;
import br.com.cavsystem.dominio.entity.Usuario;
import br.com.cavsystem.dominio.entity.dto.OcorrenciaDTO;
import br.com.cavsystem.exception.BusinessException;
import br.com.cavsystem.service.GeradorRelatorioService;
import br.com.cavsystem.service.OcorrenciaService;
import br.com.cavsystem.service.UsuarioService;
import br.com.cavsystem.util.ConstantesArchive;

@RestController
@RequestMapping("ocorrencia")
public class OcorrenciaControllerRest extends RestBase<OcorrenciaDTO, Long>  {

	@Autowired
	private OcorrenciaService service;
	
	@Autowired
	private OcorrenciaConverter converter;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private UsuarioConverter usuarioConverter;
	
	@Autowired
	private GeradorRelatorioService relatorio;
	
	@Autowired
	private ServletContext servletContext;
		
	
	@RequestMapping(value="/ocorrenciaPorCondominio/{id}", method=RequestMethod.GET)
    public ResponseEntity<List<OcorrenciaDTO>> uploadArquivo(@PathVariable Long id) throws Exception {
		List<OcorrenciaDTO> dto = converter.convertToDTO(service.OcorrenciaPorCondominio(id));
        return new ResponseEntity<List<OcorrenciaDTO>>(dto, HttpStatus.OK);
    }
	
	@Override
	protected void acaoRemover(Long id) throws BusinessException {
		service.excluir(id);		
	}


	@Override
	protected OcorrenciaDTO acaoIncluir(OcorrenciaDTO t)
			throws BusinessException {
		Usuario usr = usuarioService.obter(t.getUsuarioCriador().getId());
		t.setUsuarioCriador(usuarioConverter.convertToDTO(usr));
		t.setDataRegistro(new Date());	
		
		Ocorrencia oc = service.incluir(converter.convertToEntity(t));
				
		return converter.convertToDTO(oc);
	}


	@Override
	protected OcorrenciaDTO acaoAtualizar(OcorrenciaDTO t)
			throws BusinessException {
		return converter.convertToDTO(service.alterar(converter.convertToEntity(t)));
	}


	@Override
	protected OcorrenciaDTO acaoObter(Long id) throws BusinessException {
		return converter.convertToDTO(service.obter(id));
	}


	@Override
	protected List<OcorrenciaDTO> acaoListar() {
		return null;
	}
	
	


	@RequestMapping(method = RequestMethod.GET, value = "/visualizar")
   	public void imprimirOcorrencia(
   			@RequestParam(required = false, value = "id_ocorrencia") Long id_ocorrencia,
   			@RequestParam(required = false, value = "usuario") String usuario,   			
   			HttpServletResponse response) throws IOException, BusinessException {	
    	
		
		Ocorrencia oc = service.obter(id_ocorrencia);
		
	 byte[] documentBody = null;
    	OutputStream outputStream = null;
       	try {
       		documentBody = relatorio.gerarOcorrencia(oc.getTitulo(), servletContext.getRealPath("/relatorios/"), usuario, oc.getCondominio().getNome(), oc.getUsuarioCriador().getLogin(), oc.getDataOcorrencia(), oc.getDataRegistro(), oc.getDescricao());
       		outputStream = response.getOutputStream();
       		response.setContentType(ConstantesArchive.PDF_MIME_TYPE);
       		response.setHeader("Content-Disposition", "inline; filename=OCORRENCIA" + ConstantesArchive.EXTENSAO_PDF);
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
