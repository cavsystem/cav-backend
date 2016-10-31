package br.com.cavsystem.repository.jpa;

import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import br.com.cavsystem.dominio.entity.VeiculoMorador;
import br.com.cavsystem.repository.DAOSuporteJPA;
import br.com.cavsystem.repository.VeiculoMoradorDAO;

@Repository
public class VeiculoMoradorDAOImpl extends DAOSuporteJPA<VeiculoMorador, Long> implements VeiculoMoradorDAO {



	@SuppressWarnings("unchecked")
	@Override
	public List<VeiculoMorador> veiculoMoradorPorCondominio(Long id) {
		Query q = 
	persistencia.createQuery("select vm from VeiculoMorador vm where vm.morador.apartamento.condominio.id = :id");
		q.setParameter("id", id);	
		return q.getResultList();
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<VeiculoMorador> veiculoMoradorPorMorador(Long id) {
		Query q = persistencia.createQuery("select vm from VeiculoMorador vm where vm.morador.id = :id");
		q.setParameter("id", id);	
		return q.getResultList();
	}	
	
	
}
