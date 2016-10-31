package br.com.cavsystem.service;

import java.util.List;

import br.com.cavsystem.dominio.entity.VeiculoMorador;
import br.com.cavsystem.exception.BusinessException;

public interface VeiculoMoradorService {
	
	VeiculoMorador incluir(VeiculoMorador veiculoMorador) throws BusinessException;
	
	VeiculoMorador obter(Long id) throws BusinessException;
	
	VeiculoMorador alterar(VeiculoMorador veiculoMorador) throws BusinessException;
	
	void excluir(Long id) throws BusinessException;	
	
	List<VeiculoMorador> listar();

	List<VeiculoMorador> veiculoMoradorPorCondominio(Long id);
	
	List<VeiculoMorador> veiculoMoradorPorMorador(Long id);
	
}