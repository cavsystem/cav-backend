package br.com.cavsystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.com.cavsystem.dominio.entity.Apartamento;
import br.com.cavsystem.exception.BusinessException;
import br.com.cavsystem.repository.ApartamentoDAO;
import br.com.cavsystem.service.ApartamentoService;

@Service
@Transactional
public class ApartamentoServiceImpl implements ApartamentoService {

	@Autowired
	private ApartamentoDAO dao;

	@Override
	public Apartamento incluir(Apartamento apartamento)throws BusinessException {		
		return dao.incluir(apartamento);
	}

	@Override
	public Apartamento obter(Long id) throws BusinessException {
		return dao.obter(id);
	}

	@Override
	public Apartamento alterar(Apartamento apartamento)
			throws BusinessException {
		return dao.atualizar(apartamento);
	}

	@Override
	public void excluir(Long id) throws BusinessException {
		dao.excluir(id);
		
	}

	@Override
	public List<Apartamento> listar() {
		return null;
	}

	@Override
	public List<Apartamento> apartamentosPorCondominio(Long id)
			throws BusinessException {
		return dao.apartamentoPorCondominio(id);
	}

	

	
}
