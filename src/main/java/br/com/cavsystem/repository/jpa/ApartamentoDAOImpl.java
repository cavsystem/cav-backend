package br.com.cavsystem.repository.jpa;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.cavsystem.dominio.entity.Apartamento;
import br.com.cavsystem.repository.ApartamentoDAO;
import br.com.cavsystem.repository.DAOSuporteJPA;

@Repository
public class ApartamentoDAOImpl extends DAOSuporteJPA<Apartamento, Long> implements ApartamentoDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Apartamento> apartamentoPorCondominio(Long id) {
		Query q = persistencia.createQuery("select a from Apartamento a where a.condominio.id = :id order by a.nome asc");
		q.setParameter("id", id);		
		return q.getResultList();
	}
	
	
		
	
	
}
