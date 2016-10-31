package br.com.cavsystem.service;

import java.util.Date;
import java.util.List;
import br.com.cavsystem.dominio.entity.Visita;
import br.com.cavsystem.dominio.enums.AtivoInativoEnum;
import br.com.cavsystem.exception.BusinessException;

public interface VisitaService {

	Visita incluir(Visita visita) throws BusinessException;
	
	Visita obter(Long id) throws BusinessException;
	
	Visita alterar(Visita visita) throws BusinessException;
	
	void excluir(Long id) throws BusinessException;	
	
	List<Visita> buscaVisitaPorCondominio(Long id, AtivoInativoEnum ativo);
	
	Visita finalizarVisitas(Visita visita) throws BusinessException;
	
	List<Visita> listaPorCondominioData(Long id,Date inicio,Date fim,AtivoInativoEnum liberado);

	
}
