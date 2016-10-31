package br.com.cavsystem.repository;

import br.com.cavsystem.dominio.entity.ImagemVisitante;

public interface ImagemVisitanteDAO extends DAOManter<ImagemVisitante, Long>{
	
	ImagemVisitante imagemPorIdVisitante(Long id);
}
