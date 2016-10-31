package br.com.cavsystem.dominio.entity.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;



public class RetornoLoginDTO {

	private Long idUser;
	
	private String login;
		
    private boolean enabled;
   
    private Collection<? extends GrantedAuthority> autorizacoes;
    
    private String token;
    
    private CondominioDTO condominio;

	public RetornoLoginDTO(UserDetails details,String token , CondominioDTO condominio, Long iduser) {
		super();
		this.idUser = iduser;;
		this.login = details.getUsername();
		this.enabled = details.isEnabled();
		this.autorizacoes = details.getAuthorities();
		this.token = token;
		this.condominio = condominio != null ? condominio : null;
	}

	public String getLogin() {
		return login;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public Collection<? extends GrantedAuthority> getAutorizacoes() {
		return autorizacoes;
	}

	public String getToken() {
		return token;
	}

	public CondominioDTO getCondominio() {
		return condominio;
	}

	public Long getIdUser() {
		return idUser;
	}



}
