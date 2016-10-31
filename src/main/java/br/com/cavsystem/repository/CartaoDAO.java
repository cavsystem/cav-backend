package br.com.cavsystem.repository;

import java.util.List;

import br.com.cavsystem.dominio.entity.Cartao;


public interface CartaoDAO extends DAOManter<Cartao, Long>{

	List<Cartao> cartaoPorCondominio(Long id);
	
}
