package br.com.cavsystem.repository;

import java.util.Date;
import java.util.List;
import br.com.cavsystem.dominio.entity.Correspondencia;
import br.com.cavsystem.dominio.enums.SimNaoEnum;

public interface CorrespondenciaDAO extends DAOManter<Correspondencia, Long>{

	
	List<Correspondencia> listaPorApartamento(Long id,SimNaoEnum liberado);
	
	List<Correspondencia> listaPorCondominioData(Long id,Date inicio,Date fim,SimNaoEnum liberado);
	
}
