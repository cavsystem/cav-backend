package br.com.cavsystem.service;

import java.util.List;
import br.com.cavsystem.dominio.entity.Autorizacao;
import br.com.cavsystem.dominio.enums.RoleAcesso;
import br.com.cavsystem.exception.BusinessException;

public interface AutorizacaoService {

	List<Autorizacao> autorizacoes(RoleAcesso role) throws BusinessException;
		
	List<Autorizacao> lista();
	
	 void cadastra(List<Autorizacao> autorizacoes)throws BusinessException;	
}
