package br.com.cavsystem.repository;


import java.util.List;
import br.com.cavsystem.dominio.entity.Apartamento;

public interface ApartamentoDAO extends DAOManter<Apartamento, Long> {

	List<Apartamento> apartamentoPorCondominio(Long id);
	
}
