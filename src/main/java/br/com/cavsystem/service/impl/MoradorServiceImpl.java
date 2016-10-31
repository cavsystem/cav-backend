package br.com.cavsystem.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cavsystem.dominio.entity.Condominio;
import br.com.cavsystem.dominio.entity.Morador;
import br.com.cavsystem.dominio.entity.Usuario;
import br.com.cavsystem.dominio.enums.RoleAcesso;
import br.com.cavsystem.exception.BusinessException;
import br.com.cavsystem.repository.AutorizacaoDAO;
import br.com.cavsystem.repository.MoradorDAO;
import br.com.cavsystem.service.CondominioService;
import br.com.cavsystem.service.MoradorService;

@Service
public class MoradorServiceImpl implements MoradorService {

	@Autowired
	private MoradorDAO dao;
	
	@Autowired
	private CondominioService condominioService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AutorizacaoDAO daoAutorizacao;

	@Override
	public List<Morador> moradorPorCondominio(Long id) {
		return dao.moradorPorCondominio(id);
	}

	@Override
	@Transactional
	public Morador incluir(Morador morador) throws BusinessException {
		
		Condominio cd = condominioService.obter(morador.getApartamento().getCondominio().getId());
	    int qtd = cd.getPlano().getNumeroMoradores();
		int qtdAtual = 0;
	    List<Morador> lista = moradorPorCondominio(morador.getApartamento().getCondominio().getId());
	    
	    if(lista != null){
	    	qtdAtual = lista.size();
	    }
	    
	    if((qtd - qtdAtual) > 0){
	    	if(morador.getUsuario() != null){
	    	Usuario user = morador.getUsuario();
			user.setSenha(passwordEncoder.encode(user.getSenha()));
			user.setEnabled(true);
			user.setUltimaDataSenhaReset(new Date());
			user.setAutorizacoes(daoAutorizacao.autorizacoes(RoleAcesso.ROLE_MORADOR));
	    	}
			return dao.incluir(morador);
	    }    
			return null;	
		
		
	}

	@Override
	public Morador obter(Long id) throws BusinessException {
		return dao.obter(id);
	}

	@Override
	@Transactional
	public Morador alterar(Morador morador) throws BusinessException {
      return dao.atualizar(morador);
	}

	@Override
	@Transactional
	public void excluir(Long id) throws BusinessException {
		dao.excluir(id);
	}

	@Override
	public List<Morador> listar() {
		return null;
	}

	@Override
	public List<Morador> moradorPorApartamento(Long id) {
		return dao.moradorPorApartamento(id);
	}

	

	
}
