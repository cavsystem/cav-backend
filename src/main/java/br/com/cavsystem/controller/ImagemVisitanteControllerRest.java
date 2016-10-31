package br.com.cavsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.com.cavsystem.dominio.converter.ImagemVisitanteConverter;
import br.com.cavsystem.dominio.entity.ImagemVisitante;
import br.com.cavsystem.dominio.entity.dto.ImagemVisitanteDTO;
import br.com.cavsystem.exception.BusinessException;
import br.com.cavsystem.service.ImagemVisitanteService;
import br.com.cavsystem.service.VisitanteService;

@RestController
@RequestMapping("imagemVisitante")
public class ImagemVisitanteControllerRest extends RestBase<ImagemVisitanteDTO, Long>  {

	@Autowired
	private ImagemVisitanteService service;
	
	@Autowired
	private VisitanteService visitanteService;
	
	@Autowired
	private ImagemVisitanteConverter converter;
		
	@RequestMapping(value="/buscaPorVisitante", method=RequestMethod.POST)
	public ResponseEntity<ImagemVisitanteDTO> buscaVisitantePorCpf(@RequestBody Long id) throws BusinessException{		
		ImagemVisitante v  = service.imagemPorIdVisitante(id);
		ImagemVisitanteDTO dto = null;
		if(v != null){
			dto = converter.convertToDTO(v);
		}			
		return new ResponseEntity<ImagemVisitanteDTO>(dto, HttpStatus.OK);
	}

	
	@RequestMapping(value="/cadastroImagem", method=RequestMethod.POST)
    public ResponseEntity<ImagemVisitanteDTO> uploadArquivo(@RequestBody ImagemVisitanteDTO dtorec) throws Exception {
				ImagemVisitanteDTO dto =   converter.convertToDTO(service.alterar(converter.convertToEntity(dtorec)));
        return new ResponseEntity<ImagemVisitanteDTO>(dto, HttpStatus.OK);
    }
	


	@Override
	protected ImagemVisitanteDTO acaoObter(Long id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	protected List<ImagemVisitanteDTO> acaoListar() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	protected ImagemVisitanteDTO acaoIncluir(ImagemVisitanteDTO t)
			throws BusinessException {
		return converter.convertToDTO(service.incluir(converter.convertToEntity(t)));
	}



	@Override
	protected ImagemVisitanteDTO acaoAtualizar(ImagemVisitanteDTO t)
			throws BusinessException {
		return converter.convertToDTO(service.alterar(converter.convertToEntity(t)));
	}


	@Override
	protected void acaoRemover(Long id) throws BusinessException {
		service.excluir(id);		
	}
	
	
	
	
}
