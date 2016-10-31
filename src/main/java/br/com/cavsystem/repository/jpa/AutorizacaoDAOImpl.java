package br.com.cavsystem.repository.jpa;

import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import br.com.cavsystem.dominio.entity.Autorizacao;
import br.com.cavsystem.dominio.enums.RoleAcesso;
import br.com.cavsystem.repository.AutorizacaoDAO;
import br.com.cavsystem.repository.DAOSuporteJPA;

@Repository
public class AutorizacaoDAOImpl extends DAOSuporteJPA<Autorizacao, Long> implements AutorizacaoDAO {

	

	@SuppressWarnings("unchecked")
	@Override
	public List<Autorizacao> autorizacoes(RoleAcesso role) {
		
		Query q = persistencia.createQuery("select a from Autorizacao a where a.nome = :nome");
		q.setParameter("nome", role);
		return q.getResultList();
	}
	
	
		
	
	
}
