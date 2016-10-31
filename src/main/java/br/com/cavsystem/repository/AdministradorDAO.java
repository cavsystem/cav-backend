package br.com.cavsystem.repository;

import java.util.List;

import br.com.cavsystem.dominio.entity.Administrador;

public interface AdministradorDAO extends DAOManter<Administrador, Long> {

	List<Administrador> administradoresPorCondominio(Long id);
	
	Administrador administradorPorIdUsuario(Long idUsuario);
	
}
