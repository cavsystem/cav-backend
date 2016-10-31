package br.com.cavsystem.service;

import java.util.List;

import br.com.cavsystem.dominio.entity.ImagemVisitante;
import br.com.cavsystem.exception.BusinessException;

public interface ImagemVisitanteService {

	ImagemVisitante incluir(ImagemVisitante imagemVisitante) throws BusinessException;
	
	ImagemVisitante obter(Long id) throws BusinessException;
	
	ImagemVisitante alterar(ImagemVisitante imagemVisitante) throws BusinessException;
	
	void excluir(Long id) throws BusinessException;	
	
	List<ImagemVisitante> listar();
	
	ImagemVisitante imagemPorIdVisitante(Long id)throws BusinessException;
		
	
}
