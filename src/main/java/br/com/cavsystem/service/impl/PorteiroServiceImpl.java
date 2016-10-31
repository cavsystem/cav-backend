package br.com.cavsystem.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.com.cavsystem.dominio.entity.Condominio;
import br.com.cavsystem.dominio.entity.Porteiro;
import br.com.cavsystem.dominio.entity.Usuario;
import br.com.cavsystem.dominio.enums.RoleAcesso;
import br.com.cavsystem.exception.BusinessException;
import br.com.cavsystem.repository.AutorizacaoDAO;
import br.com.cavsystem.repository.PorteiroDAO;
import br.com.cavsystem.service.CondominioService;
import br.com.cavsystem.service.PorteiroService;

@Service
@Transactional
public class PorteiroServiceImpl implements PorteiroService {

	@Autowired
	private PorteiroDAO dao;
	
	@Autowired
	private AutorizacaoDAO daoAutorizacao;
	
	@Autowired
	private CondominioService condominioService;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@Override
	public Porteiro incluir(Porteiro porteiro) throws BusinessException {
		
		Condominio cd = condominioService.obter(porteiro.getCondominio().getId());
	    int qtd = cd.getPlano().getNumeroPorteiros();
		int qtdAtual = 0;
	    List<Porteiro> lista = porteiroPorCondominio(cd.getId());
	    
	    if(lista != null){
	    	qtdAtual = lista.size();
	    }
	    
	    if((qtd - qtdAtual) > 0){
	    	Usuario user = porteiro.getUsuario();
			user.setSenha(passwordEncoder.encode(user.getSenha()));
			user.setEnabled(true);
			user.setUltimaDataSenhaReset(new Date());
			user.setAutorizacoes(daoAutorizacao.autorizacoes(RoleAcesso.ROLE_PORTEIRO));
			
			return dao.incluir(porteiro);
	    }    
			return null;	
	}

	@Override
	public Porteiro obter(Long id) throws BusinessException {
		return dao.obter(id);
	}

	@Override
	public Porteiro alterar(Porteiro porteiro) throws BusinessException {
		return dao.atualizar(porteiro);
	}

	@Override
	public void excluir(Long id) throws BusinessException {
		dao.excluir(id);
		
	}

	@Override
	public List<Porteiro> listar() {
		return null;
	}

	@Override
	public List<Porteiro> porteiroPorCondominio(Long id)
			throws BusinessException {
		return dao.porteiroPorCondominio(id);
	}

	

	
}
