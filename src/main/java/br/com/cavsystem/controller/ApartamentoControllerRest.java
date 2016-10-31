package br.com.cavsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.com.cavsystem.dominio.converter.ApartamentoConverter;
import br.com.cavsystem.dominio.entity.dto.ApartamentoDTO;
import br.com.cavsystem.exception.BusinessException;
import br.com.cavsystem.service.ApartamentoService;

@RestController
@RequestMapping("apartamento")
public class ApartamentoControllerRest extends RestBase<ApartamentoDTO, Long>  {
	
	@Autowired
	private ApartamentoService service;
	
	@Autowired
	private ApartamentoConverter converter;

	@Override
	protected ApartamentoDTO acaoObter(Long id) throws BusinessException {
		return converter.convertToDTO(service.obter(id));
	}

	@Override
	protected List<ApartamentoDTO> acaoListar() {
		return null;
	}

	@Override
	protected ApartamentoDTO acaoIncluir(ApartamentoDTO t)
			throws BusinessException {
		return converter.convertToDTO(service.incluir(converter.convertToEntity(t)));
	}

	@Override
	protected ApartamentoDTO acaoAtualizar(ApartamentoDTO t)
			throws BusinessException {
		return converter.convertToDTO(service.alterar(converter.convertToEntity(t)));
	}

	@Override
	protected void acaoRemover(Long id) throws BusinessException {
		service.excluir(id);		
	}	
	
	@RequestMapping(value="/buscaPorCondominio/{id}", method=RequestMethod.GET)
	public ResponseEntity<List<ApartamentoDTO>> listaAps(@PathVariable Long id) throws BusinessException{		
		List<ApartamentoDTO> lista = converter.convertToDTO(service.apartamentosPorCondominio(id));
	return new ResponseEntity<List<ApartamentoDTO>>(lista,HttpStatus.OK);
	}

	
	
}
