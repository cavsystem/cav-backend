package br.com.cavsystem.repository.jpa;

import org.springframework.stereotype.Repository;
import br.com.cavsystem.dominio.entity.Condominio;
import br.com.cavsystem.repository.CondominioDAO;
import br.com.cavsystem.repository.DAOSuporteJPA;

@Repository
public class CondominioDAOImpl extends DAOSuporteJPA<Condominio, Long> implements CondominioDAO {


	
}
