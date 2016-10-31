package br.com.cavsystem.service;

import java.util.List;

import br.com.cavsystem.dominio.entity.Morador;
import br.com.cavsystem.exception.BusinessException;

public interface MoradorService {
	
	Morador incluir(Morador morador) throws BusinessException;
	
	Morador obter(Long id) throws BusinessException;
	
	Morador alterar(Morador morador) throws BusinessException;
	
	void excluir(Long id) throws BusinessException;	
	
	List<Morador> listar();

	List<Morador> moradorPorCondominio(Long id);
	
	List<Morador> moradorPorApartamento(Long id);
	
}