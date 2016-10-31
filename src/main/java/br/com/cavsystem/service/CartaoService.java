package br.com.cavsystem.service;

import java.util.List;

import br.com.cavsystem.dominio.entity.Cartao;
import br.com.cavsystem.exception.BusinessException;

public interface CartaoService {

	Cartao incluir(Cartao cartao) throws BusinessException;
	
	Cartao obter(Long id) throws BusinessException;
	
	Cartao alterar(Cartao cartao) throws BusinessException;
	
	void excluir(Long id) throws BusinessException;	
	
	List<Cartao> listar();
	
	List<Cartao> cartaoPorCondominio(Long id);
	
		
	
}
