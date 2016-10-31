package br.com.cavsystem.repository.jpa;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.cavsystem.dominio.entity.Morador;
import br.com.cavsystem.repository.DAOSuporteJPA;
import br.com.cavsystem.repository.MoradorDAO;

@Repository
public class MoradorDAOImpl extends DAOSuporteJPA<Morador, Long> implements MoradorDAO {



	@SuppressWarnings("unchecked")
	@Override
	public List<Morador> moradorPorCondominio(Long id) {
		Query q = persistencia.createQuery("select m from Morador m where m.apartamento.condominio.id = :id");
		q.setParameter("id", id);	
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Morador> moradorPorApartamento(Long id) {
		Query q = persistencia.createQuery("select m from Morador m where m.apartamento.id = :id");
		q.setParameter("id", id);	
		return q.getResultList();
	}
	
	
		
	
	
}
