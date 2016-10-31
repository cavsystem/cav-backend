package br.com.cavsystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cavsystem.dominio.entity.Visitante;
import br.com.cavsystem.exception.BusinessException;
import br.com.cavsystem.repository.VisitanteDAO;
import br.com.cavsystem.service.VisitanteService;

@Service
@Transactional
public class VisitanteServiceImpl implements VisitanteService {

	@Autowired
	private VisitanteDAO dao;
	
	@Override
	public Visitante incluir(Visitante visitante) throws BusinessException {
		return dao.incluir(visitante);
	}

	@Override
	public Visitante obter(Long id) throws BusinessException {
		return dao.obter(id);
	}

	@Override
	public Visitante alterar(Visitante visitante) throws BusinessException {
		return dao.atualizar(visitante);
	}

	@Override
	public void excluir(Long id) throws BusinessException {
		
	}

	@Override
	public List<Visitante> listar() {
		return dao.listar();
	}

	@Override
	public Visitante buscaVisitantePorCpf(String cpf) throws BusinessException {
		return dao.buscaVisitantePorCpf(cpf);
	}

}
