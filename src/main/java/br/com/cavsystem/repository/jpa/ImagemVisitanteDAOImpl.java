package br.com.cavsystem.repository.jpa;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.cavsystem.dominio.entity.ImagemVisitante;
import br.com.cavsystem.repository.DAOSuporteJPA;
import br.com.cavsystem.repository.ImagemVisitanteDAO;

@Repository
public class ImagemVisitanteDAOImpl extends DAOSuporteJPA<ImagemVisitante, Long> implements ImagemVisitanteDAO {



	@SuppressWarnings("unchecked")
	@Override
	public ImagemVisitante imagemPorIdVisitante(Long id) {
		String jpql = "select iv from ImagemVisitante iv where iv.visitante.id = :id ";
		Query qr = persistencia.createQuery(jpql);
		qr.setParameter("id", id);		
		List<ImagemVisitante> retorno = qr.getResultList();
		
		if(!retorno.isEmpty()){
			return retorno.get(0);
		}		
		return null; 
	}
	
	
	
}
