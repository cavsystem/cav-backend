package br.com.cavsystem.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cavsystem.dominio.entity.Autorizacao;
import br.com.cavsystem.dominio.entity.Usuario;
import br.com.cavsystem.dominio.enums.RoleAcesso;
import br.com.cavsystem.exception.BusinessException;
import br.com.cavsystem.service.AutorizacaoService;
import br.com.cavsystem.service.InicializaService;
import br.com.cavsystem.service.UsuarioService;

@Service
public class InicializaServiceImpl implements InicializaService{
	
	@Autowired
	private UsuarioService userService;
	
	@Autowired
	private AutorizacaoService autService;
		
	public void cadastrarUsuario(){		
				
		Usuario user = new Usuario();
		Usuario user2 = new Usuario();
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		List<Autorizacao> lista = null;
		try {
			lista = autService.autorizacoes(RoleAcesso.ROLE_SUPORTE);
		} catch (BusinessException e) {
			System.out.println("ERRO AO CRIAR AUTORIZAÇOES: "+e.getMessage());
		}
		
		user.setEnabled(true);
		user.setLogin("adriano@cavsystem.com.br");
		user.setSenha("$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi");
		user.setUltimaDataSenhaReset(new Date());
		user.setAutorizacoes(lista);
		
		user2.setEnabled(true);
		user2.setLogin("rodrigo@cavsystem.com.br");
		user2.setSenha("$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi");
		user2.setUltimaDataSenhaReset(new Date());
		user2.setAutorizacoes(lista);
		
		usuarios.add(user);
		usuarios.add(user2);
		 
		try {
			userService.cadastro(usuarios);
		} catch (BusinessException e) {
			System.out.println("ERRO AO CRIAR USUÁRIO: "+e.getMessage());
		}
	}
	
	
	
	
	
	public void cadastraAutorizacoes() throws BusinessException{			
				
		if(autService.lista().isEmpty()){	
				List<Autorizacao> autorizacoes = new ArrayList<Autorizacao>();
				Autorizacao  admin = new Autorizacao();
				admin.setNome(RoleAcesso.ROLE_ADMIN);
				autorizacoes.add(admin);
				
				Autorizacao  suporte = new Autorizacao();
				suporte.setNome(RoleAcesso.ROLE_SUPORTE);
				autorizacoes.add(suporte);
				
				Autorizacao  porteiro = new Autorizacao();
				porteiro.setNome(RoleAcesso.ROLE_PORTEIRO);
				autorizacoes.add(porteiro);
				
				Autorizacao  morador = new Autorizacao();
				morador.setNome(RoleAcesso.ROLE_MORADOR);
				autorizacoes.add(morador);	
				
				autService.cadastra(autorizacoes);
				
				cadastrarUsuario();
			}
	}

	
	
	
	// senha admin  $2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi
	
	
	
}
