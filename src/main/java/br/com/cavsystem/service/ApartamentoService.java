package br.com.cavsystem.service;

import java.util.List;
import br.com.cavsystem.dominio.entity.Apartamento;
import br.com.cavsystem.exception.BusinessException;

public interface ApartamentoService {

	Apartamento incluir(Apartamento apartamento) throws BusinessException;
	
	Apartamento obter(Long id) throws BusinessException;
	
	Apartamento alterar(Apartamento apartamento) throws BusinessException;
	
	void excluir(Long id) throws BusinessException;	
	
	List<Apartamento> listar();
	
	List<Apartamento> apartamentosPorCondominio(Long id) throws BusinessException;
		
	
}
