package br.com.cavsystem.repository.jpa;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.cavsystem.dominio.entity.VeiculoVisitante;
import br.com.cavsystem.dominio.enums.AtivoInativoEnum;
import br.com.cavsystem.repository.DAOSuporteJPA;
import br.com.cavsystem.repository.VeiculoVisitanteDAO;

@Repository
public class VeiculoVisitanteDAOImpl extends DAOSuporteJPA<VeiculoVisitante, Long> implements VeiculoVisitanteDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<VeiculoVisitante> VeiculoVisitantePorVisitante(Long id) {
		Query q = persistencia.createQuery("select vv from VeiculoVisitante vv where vv.visitante.id = :id and vv.ativo = :ativo");
		q.setParameter("id", id);
		q.setParameter("ativo", AtivoInativoEnum.S);
		return q.getResultList();
	}

	
}
