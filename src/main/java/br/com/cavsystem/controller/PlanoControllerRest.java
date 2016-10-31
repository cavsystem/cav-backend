package br.com.cavsystem.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.cavsystem.dominio.converter.PlanoConverter;
import br.com.cavsystem.dominio.entity.dto.PlanoDTO;
import br.com.cavsystem.exception.BusinessException;
import br.com.cavsystem.service.PlanoService;

@RestController
@RequestMapping("plano")
public class PlanoControllerRest extends RestBase<PlanoDTO, Long>  {
	
	@Autowired
	private PlanoService service;
	
	@Autowired
	private PlanoConverter converter;

	@Override
	protected PlanoDTO acaoObter(Long id) throws BusinessException {
		return converter.convertToDTO(service.obter(id));
	}

	@Override
	protected List<PlanoDTO> acaoListar() {
		return converter.convertToDTO(service.listar());
	}

	@Override
	protected PlanoDTO acaoIncluir(PlanoDTO t) throws BusinessException {
		return converter.convertToDTO(service.incluir(converter.convertToEntity(t)));
	}

	@Override
	protected PlanoDTO acaoAtualizar(PlanoDTO t) throws BusinessException {
		return converter.convertToDTO(service.alterar(converter.convertToEntity(t)));
	}

	@Override
	protected void acaoRemover(Long id) throws BusinessException {
		service.excluir(id);		
	}

	
}
