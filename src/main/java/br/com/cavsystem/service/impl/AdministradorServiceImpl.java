package br.com.cavsystem.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cavsystem.dominio.entity.Administrador;
import br.com.cavsystem.dominio.entity.Condominio;
import br.com.cavsystem.dominio.entity.Usuario;
import br.com.cavsystem.dominio.enums.RoleAcesso;
import br.com.cavsystem.exception.BusinessException;
import br.com.cavsystem.repository.AdministradorDAO;
import br.com.cavsystem.repository.AutorizacaoDAO;
import br.com.cavsystem.service.AdministradorService;
import br.com.cavsystem.service.CondominioService;

@Service
public class AdministradorServiceImpl implements AdministradorService {

	@Autowired
	private AdministradorDAO dao;
	
	@Autowired
	private AutorizacaoDAO daoAutorizacao;
	
	@Autowired
	private CondominioService condominioService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public Administrador incluir(Administrador administrador)
			throws BusinessException {
	
	Condominio cd = condominioService.obter(administrador.getCondominio().getId());
    int qtd = cd.getPlano().getNumeroAdministradores();
	int qtdAtual = 0;
    List<Administrador> lista = administradoresPorCondominio(administrador.getCondominio().getId());
    
    if(lista != null){
    	qtdAtual = lista.size();
    }
    
    if((qtd - qtdAtual) > 0){
    	Usuario user = administrador.getUsuario();
		user.setSenha(passwordEncoder.encode(user.getSenha()));
		user.setEnabled(true);
		user.setUltimaDataSenhaReset(new Date());
		user.setAutorizacoes(daoAutorizacao.autorizacoes(RoleAcesso.ROLE_ADMIN));
		
		return dao.incluir(administrador);
    }    
		return null;		
	}

	@Override
	public Administrador obter(Long id) throws BusinessException {
		return dao.obter(id);
	}

	@Override
	@Transactional
	public Administrador alterar(Administrador administrador)
			throws BusinessException {
		return dao.atualizar(administrador);
	}

	@Override
	@Transactional
	public void excluir(Long id) throws BusinessException {
		dao.excluir(id);		
	}

	@Override
	public List<Administrador> listar() {
		return dao.listar();
	}

	@Override
	public List<Administrador> administradoresPorCondominio(Long id)
			throws BusinessException {
		return dao.administradoresPorCondominio(id);
	}
	

	
}
