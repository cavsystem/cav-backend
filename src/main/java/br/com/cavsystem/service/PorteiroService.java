package br.com.cavsystem.service;

import java.util.List;
import br.com.cavsystem.dominio.entity.Porteiro;
import br.com.cavsystem.exception.BusinessException;

public interface PorteiroService {

	Porteiro incluir(Porteiro porteiro) throws BusinessException;
	
	Porteiro obter(Long id) throws BusinessException;
	
	Porteiro alterar(Porteiro porteiro) throws BusinessException;
	
	void excluir(Long id) throws BusinessException;	
	
	List<Porteiro> listar();	
	
	List<Porteiro> porteiroPorCondominio(Long id) throws BusinessException;

}
