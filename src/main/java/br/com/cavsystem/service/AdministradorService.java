package br.com.cavsystem.service;

import java.util.List;

import br.com.cavsystem.dominio.entity.Administrador;
import br.com.cavsystem.exception.BusinessException;

public interface AdministradorService {

    Administrador incluir(Administrador administrador) throws BusinessException;
	
    Administrador obter(Long id) throws BusinessException;
	
    Administrador alterar(Administrador administrador) throws BusinessException;
	
	void excluir(Long id) throws BusinessException;	
	
	List<Administrador> listar();
	
	List<Administrador> administradoresPorCondominio(Long id) throws BusinessException;
		
	
}
