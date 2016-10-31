package br.com.cavsystem.service;

import java.util.List;
import br.com.cavsystem.dominio.entity.Plano;
import br.com.cavsystem.exception.BusinessException;

public interface PlanoService {

	Plano incluir(Plano plano) throws BusinessException;
	
	Plano obter(Long id) throws BusinessException;
	
	Plano alterar(Plano plano) throws BusinessException;
	
	void excluir(Long id) throws BusinessException;	
	
	List<Plano> listar();	
}
