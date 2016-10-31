package br.com.cavsystem.repository.jpa;

import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import br.com.cavsystem.dominio.entity.Visita;
import br.com.cavsystem.dominio.enums.AtivoInativoEnum;
import br.com.cavsystem.repository.DAOSuporteJPA;
import br.com.cavsystem.repository.VisitaDAO;

@Repository
public class VisitaDAOImpl extends DAOSuporteJPA<Visita, Long> implements VisitaDAO {

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Visita> buscaVisitaPorCondominio(Long id, AtivoInativoEnum ativo) {
		String jpql = "select v from Visita v where v.condominio.id = :id and v.ativo = :ativo";
		Query qr = persistencia.createQuery(jpql);
		qr.setParameter("id", id);
		qr.setParameter("ativo", ativo);
	
		return qr.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Visita> listaPorCondominioData(Long id, Date inicio, Date fim,
			AtivoInativoEnum liberado) {
		Query q = persistencia.createQuery("select v from Visita v where v.condominio.id = :id AND v.ativo = :liberado AND v.dataHoraEntrada BETWEEN :start AND :end");
		q.setParameter("id", id);
		q.setParameter("liberado", liberado);
		q.setParameter("start", inicio);
		q.setParameter("end", fim);
		return q.getResultList();
	}
	
	
	
}
