package br.com.cavsystem.repository;

import java.util.Date;
import java.util.List;
import br.com.cavsystem.dominio.entity.Visita;
import br.com.cavsystem.dominio.enums.AtivoInativoEnum;

public interface VisitaDAO extends DAOManter<Visita, Long>{

	List<Visita> buscaVisitaPorCondominio(Long id, AtivoInativoEnum ativo);
	
	List<Visita> listaPorCondominioData(Long id,Date inicio,Date fim,AtivoInativoEnum liberado);

	
}
