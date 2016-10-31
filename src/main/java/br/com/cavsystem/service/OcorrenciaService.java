package br.com.cavsystem.service;

import java.util.List;

import br.com.cavsystem.dominio.entity.Ocorrencia;
import br.com.cavsystem.exception.BusinessException;

public interface OcorrenciaService {

	Ocorrencia incluir(Ocorrencia ocorrencia) throws BusinessException;
	
	Ocorrencia obter(Long id) throws BusinessException;
	
	Ocorrencia alterar(Ocorrencia ocorrencia) throws BusinessException;
	
	void excluir(Long id) throws BusinessException;	
	
	List<Ocorrencia> listar();	
	
	List<Ocorrencia> OcorrenciaPorCondominio(Long id);

}
