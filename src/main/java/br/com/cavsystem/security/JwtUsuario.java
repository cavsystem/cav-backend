package br.com.cavsystem.security;

import java.util.Collection;
import java.util.Date;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public final class JwtUsuario implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final Long id;
	
	private final String login;
	
	private final String senha;
	
    private final boolean enabled;
   
    private final Date ultimaDataSenhaReset;
    
    private final Collection<? extends GrantedAuthority> autorizacoes;
      

	public JwtUsuario(Long id, String login, String senha, boolean enabled,
			Date ultimaDataSenhaReset,
			Collection<? extends GrantedAuthority> autorizacoes) {
		super();
		this.id = id;
		this.login = login;
		this.senha = senha;
		this.enabled = enabled;
		this.ultimaDataSenhaReset = ultimaDataSenhaReset;
		this.autorizacoes = autorizacoes;
	}
	
	public Long getId() {
		return id;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return autorizacoes;
	}


	@Override
	public String getPassword() {
		return senha;
	}


	@Override
	public String getUsername() {
		return login;
	}


	@Override
	public boolean isAccountNonExpired() {
		return true;
	}


	@Override
	public boolean isAccountNonLocked() {
		return true;
	}


	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	public boolean isEnabled() {
		return enabled;
	}


	public Date getUltimaDataSenhaReset() {
		return ultimaDataSenhaReset;
	}

}
