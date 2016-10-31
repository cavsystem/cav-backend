package br.com.cavsystem.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cavsystem.dominio.converter.CondominioConverter;
import br.com.cavsystem.dominio.entity.Condominio;
import br.com.cavsystem.dominio.entity.dto.CondominioDTO;
import br.com.cavsystem.exception.BusinessException;
import br.com.cavsystem.service.CondominioService;


@RestController
@RequestMapping("condominio")
public class CondominioControllerRest extends RestBase<CondominioDTO, Long>  {

	@Autowired
	private CondominioService service;
	
	@Autowired
	private CondominioConverter converter;

	@Override
	protected CondominioDTO acaoObter(Long id) throws BusinessException {
		return converter.convertToDTO(service.obter(id));
	}

	@Override
	protected List<CondominioDTO> acaoListar() {
		return converter.convertToDTO(service.listar());
	}

	@Override
	protected CondominioDTO acaoIncluir(CondominioDTO t)
			throws BusinessException {
		return converter.convertToDTO(service.incluir(converter.convertToEntity(t)));
	}

	@Override
	protected CondominioDTO acaoAtualizar(CondominioDTO t)
			throws BusinessException {
		Condominio retorno = service.alterar(converter.convertToEntity(t));
		return converter.convertToDTO(retorno);
	}

	@Override
	protected void acaoRemover(Long id) throws BusinessException {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
