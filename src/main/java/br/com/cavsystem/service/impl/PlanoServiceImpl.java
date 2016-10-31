package br.com.cavsystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.com.cavsystem.dominio.entity.Plano;
import br.com.cavsystem.exception.BusinessException;
import br.com.cavsystem.repository.PlanoDAO;
import br.com.cavsystem.service.PlanoService;

@Service
@Transactional
public class PlanoServiceImpl implements PlanoService {

	@Autowired
	private PlanoDAO dao;

	@Override
	public Plano incluir(Plano plano) throws BusinessException {
		return dao.incluir(plano);
	}

	@Override
	public Plano obter(Long id) throws BusinessException {
		return dao.obter(id);
	}

	@Override
	public Plano alterar(Plano plano) throws BusinessException {
		return dao.atualizar(plano);
	}

	@Override
	public void excluir(Long id) throws BusinessException {
		dao.excluir(id);
	}

	@Override
	public List<Plano> listar(){
		return dao.listar();
	}

	
}
