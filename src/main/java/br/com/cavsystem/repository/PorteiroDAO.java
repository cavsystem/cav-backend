package br.com.cavsystem.repository;

import java.util.List;

import br.com.cavsystem.dominio.entity.Porteiro;

public interface PorteiroDAO extends DAOManter<Porteiro, Long> {

	List<Porteiro> porteiroPorCondominio(Long id);
	
	Porteiro porteiroPorIdUsuario(Long idUsuario);
}
