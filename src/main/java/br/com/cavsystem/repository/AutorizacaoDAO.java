package br.com.cavsystem.repository;



import java.util.List;

import br.com.cavsystem.dominio.entity.Autorizacao;
import br.com.cavsystem.dominio.enums.RoleAcesso;

public interface AutorizacaoDAO extends DAOManter<Autorizacao, Long> {

	List<Autorizacao> autorizacoes(RoleAcesso role);
}
