package br.com.cavsystem.service;


import java.util.List;

import br.com.cavsystem.dominio.entity.Usuario;
import br.com.cavsystem.exception.BusinessException;

public interface UsuarioService {
	
	Usuario obter(Long id) throws BusinessException;
	
	void cadastro(List<Usuario> usrs)throws BusinessException;
	
}
