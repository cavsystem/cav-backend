package br.com.cavsystem.service;

import java.util.List;
import br.com.cavsystem.dominio.entity.Condominio;
import br.com.cavsystem.exception.BusinessException;

public interface CondominioService {

	Condominio incluir(Condominio condominio) throws BusinessException;
	
	Condominio obter(Long id) throws BusinessException;
	
	Condominio alterar(Condominio condominio) throws BusinessException;
	
	void excluir(Long id) throws BusinessException;	
	
	List<Condominio> listar();
	
		
	
}
