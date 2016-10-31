package br.com.cavsystem.repository;

import java.util.List;

import br.com.cavsystem.dominio.entity.VeiculoVisitante;

public interface VeiculoVisitanteDAO extends DAOManter<VeiculoVisitante, Long> {

	List<VeiculoVisitante> VeiculoVisitantePorVisitante(Long id);
	
}
