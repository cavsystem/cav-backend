package br.com.cavsystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.com.cavsystem.dominio.entity.Condominio;
import br.com.cavsystem.exception.BusinessException;
import br.com.cavsystem.repository.CondominioDAO;
import br.com.cavsystem.service.CondominioService;

@Service
@Transactional
public class CondominioServiceImpl implements CondominioService {

	@Autowired
	private CondominioDAO dao;

	@Override	
	public Condominio incluir(Condominio condominio) throws BusinessException {
		return dao.incluir(condominio);
	}

	@Override
	public Condominio obter(Long id) throws BusinessException {
		return dao.obter(id);
	}

	@Override
	public Condominio alterar(Condominio condominio) throws BusinessException {
		Condominio c = dao.atualizar(condominio);
		System.out.println(c.getBairro());
		
		return c;
		
	}

	@Override
	public void excluir(Long id) throws BusinessException {
		
	}

	@Override
	public List<Condominio> listar() {
		return dao.listar();
	}
	
	
}
