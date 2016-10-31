package br.com.cavsystem.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cavsystem.dominio.entity.Usuario;
import br.com.cavsystem.exception.BusinessException;
import br.com.cavsystem.repository.UsuarioDAO;
import br.com.cavsystem.service.UsuarioService;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioDAO dao;

	@Override
	public Usuario obter(Long id) throws BusinessException {
		return dao.obter(id);
	}

	@Override
	public void cadastro(List<Usuario> usrs) throws BusinessException {
		 dao.incluir(usrs);
	}

	
	
}
