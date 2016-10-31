package br.com.cavsystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cavsystem.dominio.entity.Autorizacao;
import br.com.cavsystem.dominio.enums.RoleAcesso;
import br.com.cavsystem.exception.BusinessException;
import br.com.cavsystem.repository.AutorizacaoDAO;
import br.com.cavsystem.service.AutorizacaoService;

@Service
@Transactional
public class AutorizacaoServiceImpl implements AutorizacaoService {

	@Autowired
	private AutorizacaoDAO dao;

	@Override
	public List<Autorizacao> autorizacoes(RoleAcesso role)throws BusinessException {
		return dao.autorizacoes(role);
	}

	@Override
	public List<Autorizacao> lista() {
		return dao.listar();
	}

	@Override
	public void cadastra(List<Autorizacao> autorizacoes)
			throws BusinessException {
		dao.incluir(autorizacoes);
		
	}

}
