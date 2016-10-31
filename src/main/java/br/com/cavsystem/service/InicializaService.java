package br.com.cavsystem.service;

import br.com.cavsystem.exception.BusinessException;

public interface InicializaService {
	
	void cadastraAutorizacoes() throws BusinessException;
	
	void cadastrarUsuario();
}
