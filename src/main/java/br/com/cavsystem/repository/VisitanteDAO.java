package br.com.cavsystem.repository;

import br.com.cavsystem.dominio.entity.Visitante;

public interface VisitanteDAO extends DAOManter<Visitante, Long>{

	Visitante buscaVisitantePorCpf(String cpf);
	
}
