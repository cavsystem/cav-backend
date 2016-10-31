package br.com.cavsystem.service;

import java.util.List;
import br.com.cavsystem.dominio.entity.VeiculoVisitante;
import br.com.cavsystem.exception.BusinessException;

public interface VeiculoVisitanteService {
	
	VeiculoVisitante incluir(VeiculoVisitante veiculoVisitante) throws BusinessException;
	
	VeiculoVisitante obter(Long id) throws BusinessException;
	
	VeiculoVisitante alterar(VeiculoVisitante veiculoVisitante) throws BusinessException;
	
	void excluir(Long id) throws BusinessException;	
	
	List<VeiculoVisitante> listar();

	List<VeiculoVisitante> VeiculoVisitantePorCondominio(Long id);
	
	List<VeiculoVisitante> VeiculoVisitantePorVisitante(Long id);
	
}