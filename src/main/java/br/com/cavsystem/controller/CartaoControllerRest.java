package br.com.cavsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.com.cavsystem.dominio.converter.CartaoConverter;
import br.com.cavsystem.dominio.entity.dto.CartaoDTO;
import br.com.cavsystem.exception.BusinessException;
import br.com.cavsystem.service.CartaoService;

@RestController
@RequestMapping("cartao")
public class CartaoControllerRest extends RestBase<CartaoDTO, Long>  {
	
	@Autowired
	private CartaoService service;
	
	@Autowired
	private CartaoConverter converter;
	
	@RequestMapping(value="/cartaoPorCondominio/{id}" , method=RequestMethod.GET)
	public List<CartaoDTO> listarcartoesPorCondominio(@PathVariable Long id){
		return converter.convertToDTO(service.cartaoPorCondominio(id));
	}

	@Override
	protected CartaoDTO acaoObter(Long id) throws BusinessException {
		return converter.convertToDTO(service.obter(id));
	}

	@Override
	protected List<CartaoDTO> acaoListar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected CartaoDTO acaoIncluir(CartaoDTO t) throws BusinessException {
		return converter.convertToDTO(service.incluir(converter.convertToEntity(t)));
	}

	@Override
	protected CartaoDTO acaoAtualizar(CartaoDTO t) throws BusinessException {
		return converter.convertToDTO(service.alterar(converter.convertToEntity(t)));
	}

	@Override
	protected void acaoRemover(Long id) throws BusinessException {
		service.excluir(id);		
	}

	
	
}
