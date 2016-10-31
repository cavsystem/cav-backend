package br.com.cavsystem.repository.jpa;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.cavsystem.dominio.entity.Porteiro;
import br.com.cavsystem.repository.DAOSuporteJPA;
import br.com.cavsystem.repository.PorteiroDAO;

@Repository
public class PorteiroDAOImpl extends DAOSuporteJPA<Porteiro, Long> implements PorteiroDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Porteiro> porteiroPorCondominio(Long id) {
		Query q = persistencia.createQuery("select p from Porteiro p where p.condominio.id = :id");
		q.setParameter("id", id);	
		return q.getResultList();
	}

	@Override
	public Porteiro porteiroPorIdUsuario(Long idUsuario) {
		Query q = persistencia.createQuery("select a from Porteiro a where a.usuario.id = :id ");
		q.setParameter("id", idUsuario);		
		if(q.getResultList() != null){
			return  (Porteiro) q.getResultList().get(0);
		}
		return null;
	}

	
		
	
	
}
