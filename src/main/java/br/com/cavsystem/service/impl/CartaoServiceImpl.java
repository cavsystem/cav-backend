package br.com.cavsystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cavsystem.dominio.entity.Cartao;
import br.com.cavsystem.exception.BusinessException;
import br.com.cavsystem.repository.CartaoDAO;
import br.com.cavsystem.service.CartaoService;

@Service
@Transactional
public class CartaoServiceImpl implements CartaoService {

	@Autowired
	private CartaoDAO dao;

	@Override
	public Cartao incluir(Cartao cartao) throws BusinessException {
		return dao.incluir(cartao);
	}

	@Override
	public Cartao obter(Long id) throws BusinessException {
		return dao.obter(id);
	}

	@Override
	public Cartao alterar(Cartao cartao) throws BusinessException {
		return dao.atualizar(cartao);
	}

	@Override
	public void excluir(Long id) throws BusinessException {
		dao.excluir(id);		
	}

	@Override
	public List<Cartao> listar() {
		return dao.listar();
	}

	@Override
	public List<Cartao> cartaoPorCondominio(Long id) {
		return dao.cartaoPorCondominio(id);
	}

	
	
}
