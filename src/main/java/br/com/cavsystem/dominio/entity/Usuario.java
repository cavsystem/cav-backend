package br.com.cavsystem.dominio.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import br.com.cavsystem.dominio.entity.dto.UsuarioDTO;


/**
 * @author Rodrigo
 *
 */
@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String login;
	
	@NotNull
	private String senha;
	
    @NotNull
    private boolean enabled;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date ultimaDataSenhaReset;

    @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.DETACH)
    private List<Autorizacao> autorizacoes;
	
	

	public Usuario() {
		super();
	}

	public Usuario(UsuarioDTO dto) {
		super();
		this.id = dto.getId();
		this.login = dto.getLogin();
		this.senha = dto.getSenha();
		this.enabled = dto.isEnabled();
		this.ultimaDataSenhaReset = dto.getUltimaDataSenhaReset();
		this.autorizacoes = dto.getAutorizacoes() != null ? new Autorizacao().convertTo(dto.getAutorizacoes()) : null;
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

	public List<Autorizacao> getAutorizacoes() {
		return autorizacoes;
	}

	public void setAutorizacoes(List<Autorizacao> autorizacoes) {
		this.autorizacoes = autorizacoes;
	}
	
	public List<Usuario> converteToUsuario(List<UsuarioDTO> dtos){
		List<Usuario> usrs = new ArrayList<>();
		for (UsuarioDTO ud : dtos) {
			Usuario u = new Usuario(ud);
			usrs.add(u);
		}
		return usrs;		
	}
		
	
}
