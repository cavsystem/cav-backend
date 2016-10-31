package br.com.cavsystem.repository;

import java.util.List;

import br.com.cavsystem.dominio.entity.VeiculoMorador;

public interface VeiculoMoradorDAO extends DAOManter<VeiculoMorador, Long> {

	List<VeiculoMorador> veiculoMoradorPorCondominio(Long id);
	
	List<VeiculoMorador> veiculoMoradorPorMorador(Long id);
	
}
