package br.com.cavsystem.service;

import java.util.List;

import br.com.cavsystem.dominio.entity.Visitante;
import br.com.cavsystem.exception.BusinessException;

public interface VisitanteService {

	Visitante incluir(Visitante visitante) throws BusinessException;
	
	Visitante obter(Long id) throws BusinessException;
		
	Visitante alterar(Visitante visitante) throws BusinessException;
	
	void excluir(Long id) throws BusinessException;	
	
	List<Visitante> listar();
	
	Visitante buscaVisitantePorCpf(String cpf)throws BusinessException;
		
	
}
