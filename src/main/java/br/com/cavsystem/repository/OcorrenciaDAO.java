package br.com.cavsystem.repository;

import java.util.List;

import br.com.cavsystem.dominio.entity.Ocorrencia;

public interface OcorrenciaDAO extends DAOManter<Ocorrencia, Long> {

	
	List<Ocorrencia> OcorrenciaPorCondominio(Long id);

}
