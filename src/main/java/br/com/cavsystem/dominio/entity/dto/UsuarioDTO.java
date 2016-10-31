package br.com.cavsystem.dominio.entity.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import br.com.cavsystem.dominio.entity.Usuario;


public class UsuarioDTO {

	private Long id;
	
	private String login;
	
	private String senha;
	
    private boolean enabled;
   
    private Date ultimaDataSenhaReset;

    private List<AutorizacaoDTO> autorizacoes;
    

	public UsuarioDTO(Usuario usuario) {
		super();
		this.id = usuario.getId();
		this.login = usuario.getLogin();
		this.senha = usuario.getSenha();
		this.enabled = usuario.isEnabled();
		this.ultimaDataSenhaReset = usuario.getUltimaDataSenhaReset();
		this.autorizacoes = usuario.getAutorizacoes() != null ? new AutorizacaoDTO().convertTo(usuario.getAutorizacoes()) : null;
	}

	
	public UsuarioDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}


	public boolean isEnabled() {
		return enabled;
	}


	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


	public Date getUltimaDataSenhaReset() {
		return ultimaDataSenhaReset;
	}


	public void setUltimaDataSenhaReset(Date ultimaDataSenhaReset) {
		this.ultimaDataSenhaReset = ultimaDataSenhaReset;
	}

	
	public List<AutorizacaoDTO> getAutorizacoes() {
		return autorizacoes;
	}


	public void setAutorizacoes(List<AutorizacaoDTO> autorizacoes) {
		this.autorizacoes = autorizacoes;
	}

	public List<UsuarioDTO> converteToUsuario(List<Usuario> usuarios){
		List<UsuarioDTO> dtos = new ArrayList<>();
		for (Usuario u : usuarios) {
			UsuarioDTO us = new UsuarioDTO(u);
			dtos.add(us);
		}
		return dtos;		
	}

}
