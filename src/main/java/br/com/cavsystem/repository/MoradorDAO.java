package br.com.cavsystem.repository;

import java.util.List;
import br.com.cavsystem.dominio.entity.Morador;

public interface MoradorDAO extends DAOManter<Morador, Long> {

	List<Morador> moradorPorCondominio(Long id);
	
	List<Morador> moradorPorApartamento(Long id);
	
}
