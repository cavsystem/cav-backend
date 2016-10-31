package br.com.cavsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.com.cavsystem.dominio.converter.PorteiroConverter;
import br.com.cavsystem.dominio.entity.Porteiro;
import br.com.cavsystem.dominio.entity.dto.PorteiroDTO;
import br.com.cavsystem.exception.BusinessException;
import br.com.cavsystem.service.PorteiroService;

@RestController
@RequestMapping("porteiro")
public class PorteiroControllerRest extends RestBase<PorteiroDTO, Long>  {
	
	@Autowired
	private PorteiroService service;
	
	@Autowired
	private PorteiroConverter converter;

	@Override
	protected PorteiroDTO acaoObter(Long id) throws BusinessException {
		return converter.convertToDTO(service.obter(id));
	}

	@Override
	protected List<PorteiroDTO> acaoListar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected PorteiroDTO acaoIncluir(PorteiroDTO t) throws BusinessException {
		Porteiro port =  service.incluir(converter.convertToEntity(t));	
		if(port != null){
			return converter.convertToDTO(port);
		}else{
			return null;
		}	
	}

	@Override
	protected PorteiroDTO acaoAtualizar(PorteiroDTO t) throws BusinessException {
		return converter.convertToDTO(service.alterar(converter.convertToEntity(t)));
	}

	@Override
	protected void acaoRemover(Long id) throws BusinessException {
		service.excluir(id);
	}

	@RequestMapping(value="/buscaPorCondominio/{id}", method=RequestMethod.GET)
	public ResponseEntity<List<PorteiroDTO>> listaPOrteiros(@PathVariable Long id) throws BusinessException{		
		List<PorteiroDTO> lista = converter.convertToDTO(service.porteiroPorCondominio(id));
	return new ResponseEntity<List<PorteiroDTO>>(lista,HttpStatus.OK);
	}

	
}
