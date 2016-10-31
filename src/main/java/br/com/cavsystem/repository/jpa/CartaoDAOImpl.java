package br.com.cavsystem.repository.jpa;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.cavsystem.dominio.entity.Cartao;
import br.com.cavsystem.repository.CartaoDAO;
import br.com.cavsystem.repository.DAOSuporteJPA;

@Repository
public class CartaoDAOImpl extends DAOSuporteJPA<Cartao, Long> implements CartaoDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Cartao> cartaoPorCondominio(Long id) {
		Query q = persistencia.createQuery("select c from Cartao c where c.condominio.id = :id");
		q.setParameter("id", id);
		return q.getResultList();
	}
	
}
