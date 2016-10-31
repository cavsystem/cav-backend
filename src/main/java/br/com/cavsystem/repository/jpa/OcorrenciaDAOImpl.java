package br.com.cavsystem.repository.jpa;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.cavsystem.dominio.entity.Ocorrencia;
import br.com.cavsystem.repository.DAOSuporteJPA;
import br.com.cavsystem.repository.OcorrenciaDAO;

@Repository
public class OcorrenciaDAOImpl extends DAOSuporteJPA<Ocorrencia, Long> implements OcorrenciaDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Ocorrencia> OcorrenciaPorCondominio(Long id) {
		Query q = persistencia.createQuery("select o from Ocorrencia o where o.condominio.id = :id");
		q.setParameter("id", id);		
		return q.getResultList();
	}

	
		
	
	
}
