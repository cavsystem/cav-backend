package br.com.cavsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import br.com.cavsystem.dominio.converter.VisitanteConverter;
import br.com.cavsystem.dominio.entity.Visitante;
import br.com.cavsystem.dominio.entity.dto.VisitanteDTO;
import br.com.cavsystem.exception.BusinessException;
import br.com.cavsystem.service.VisitanteService;

@RestController
@RequestMapping("visitante")
public class VisitanteControllerRest extends RestBase<VisitanteDTO, Long>  {

	@Autowired
	private VisitanteService service;
	
	@Autowired
	private VisitanteConverter converter;
	
	@Override
	protected VisitanteDTO acaoObter(Long id) throws BusinessException {
		return converter.convertToDTO(service.obter(id));
	}

	@Override
	protected List<VisitanteDTO> acaoListar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected VisitanteDTO acaoIncluir(VisitanteDTO t) throws BusinessException {
		return  converter.convertToDTO(service.incluir(converter.convertToEntity(t)));
	}

	@Override
	protected VisitanteDTO acaoAtualizar(VisitanteDTO t)
			throws BusinessException {
		return converter.convertToDTO(service.alterar(converter.convertToEntity(t)));
	}

	@Override
	protected void acaoRemover(Long id) throws BusinessException {
		service.excluir(id);
		
	}
	
	@RequestMapping(value="/buscaPorCpf/{cpf}", method=RequestMethod.GET)
	public ResponseEntity<VisitanteDTO> buscaVisitantePorCpf(@PathVariable String cpf) throws BusinessException{		
		Visitante v  = service.buscaVisitantePorCpf(cpf);
		VisitanteDTO dto = null;
		if(v != null){
			dto = converter.convertToDTO(v);
		}			
		return new ResponseEntity<VisitanteDTO>(dto,HttpStatus.OK);
	}
	
	public static final int KB = 1024;
	public static final int MB = 1024 * KB;
	public static final int GB = 1024 * MB;
	
	@RequestMapping(value="/cadastroImagem", method=RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<VisitanteDTO> uploadArquivo(MultipartHttpServletRequest request) throws Exception {
		MultipartFile file = request.getFile("file");
		Long id = Long.valueOf(request.getHeader("id"));
		
		//VisitanteDTO dto = acaoObter(id);
		//dto.setImagem("");		
		
        return new ResponseEntity<VisitanteDTO>(new VisitanteDTO(), HttpStatus.OK);
    }
	
	
}
