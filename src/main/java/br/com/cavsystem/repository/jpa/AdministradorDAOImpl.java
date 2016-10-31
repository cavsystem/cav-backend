package br.com.cavsystem.repository.jpa;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.cavsystem.dominio.entity.Administrador;
import br.com.cavsystem.repository.AdministradorDAO;
import br.com.cavsystem.repository.DAOSuporteJPA;

@Repository
public class AdministradorDAOImpl extends DAOSuporteJPA<Administrador, Long> implements AdministradorDAO {
	
	@SuppressWarnings("unchecked")
	public List<Administrador> administradoresPorCondominio(Long id){		
		Query q = persistencia.createQuery("select a from Administrador a where a.condominio.id = :id ");
		q.setParameter("id", id);		
		return q.getResultList();
	}

	@Override
	public Administrador administradorPorIdUsuario(Long idUsuario) {
		Query q = persistencia.createQuery("select a from Administrador a where a.usuario.id = :id ");
		q.setParameter("id", idUsuario);		
		if(q.getResultList() != null){
			return (Administrador) q.getResultList().get(0);
		}
		return null;
	}
	

		
	
	
}
