package br.com.cavsystem.repository.jpa;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.cavsystem.dominio.entity.Visitante;
import br.com.cavsystem.repository.DAOSuporteJPA;
import br.com.cavsystem.repository.VisitanteDAO;

@Repository
public class VisitanteDAOImpl extends DAOSuporteJPA<Visitante, Long> implements VisitanteDAO {

	
	
	@SuppressWarnings("unchecked")
	public Visitante buscaVisitantePorCpf(String cpf){
		String jpql = "select v from Visitante v where v.cpf = :cpf";
		Query qr = persistencia.createQuery(jpql);
		qr.setParameter("cpf", cpf);
		
		List<Visitante> retorno = qr.getResultList();
		
		if(!retorno.isEmpty()){
			return retorno.get(0);
		}		
		return null; 
	}
	
	
	
}
