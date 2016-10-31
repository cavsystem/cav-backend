package br.com.cavsystem.repository.jpa;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import br.com.cavsystem.dominio.entity.Correspondencia;
import br.com.cavsystem.dominio.enums.SimNaoEnum;
import br.com.cavsystem.repository.CorrespondenciaDAO;
import br.com.cavsystem.repository.DAOSuporteJPA;

@Repository
public class CorrespondenciaDAOImpl extends DAOSuporteJPA<Correspondencia, Long> implements CorrespondenciaDAO {

	@Override
	@SuppressWarnings("unchecked")
	public List<Correspondencia> listaPorApartamento(Long id,SimNaoEnum liberado){
		Query q = persistencia.createQuery("select c from Correspondencia c where c.correspondeciaPara.id = :id and c.liberado = :liberado");
		q.setParameter("id", id);
		q.setParameter("liberado", liberado);
		return q.getResultList();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Correspondencia> listaPorCondominioData(Long id,Date inicio,Date fim,SimNaoEnum liberado){
		Query q = persistencia.createQuery("select c from Correspondencia c where c.correspondeciaPara.condominio.id = :id AND c.liberado = :liberado AND c.dataRecebimento BETWEEN :start AND :end");
		q.setParameter("id", id);
		q.setParameter("liberado", liberado);
		q.setParameter("start", inicio);
		q.setParameter("end", fim);
		return q.getResultList();
	}


	
}
