package br.com.cavsystem.dominio.entity.dto;

import br.com.cavsystem.dominio.entity.Administrador;
import br.com.cavsystem.dominio.enums.AtivoInativoEnum;

public class AdministradorDTO {

	private Long id;
	
	private String nome;
	
	private String rg;
	
	private String cpf;
	
	private String contato_1;
	
	private String contato_2;
	
	private AtivoInativoEnum ativo;
	
	private CondominioDTO condominio;
	
	private UsuarioDTO usuario;
	
	
	public AdministradorDTO(Administrador administrador) {
		super();
		this.id = administrador.getId();
		this.nome = administrador.getNome();
		this.rg = administrador.getRg();
		this.cpf = administrador.getCpf();
		this.contato_1 = administrador.getContato_1();
		this.contato_2 = administrador.getContato_2();
		this.usuario = new UsuarioDTO(administrador.getUsuario());
		this.condominio = new CondominioDTO(administrador.getCondominio());
		this.ativo = administrador.getAtivo();
	}

	public AdministradorDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getContato_1() {
		return contato_1;
	}

	public void setContato_1(String contato_1) {
		this.contato_1 = contato_1;
	}

	public String getContato_2() {
		return contato_2;
	}

	public void setContato_2(String contato_2) {
		this.contato_2 = contato_2;
	}

	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}

	public CondominioDTO getCondominio() {
		return condominio;
	}

	public void setCondominio(CondominioDTO condominio) {
		this.condominio = condominio;
	}

	public AtivoInativoEnum getAtivo() {
		return ativo;
	}

	public void setAtivo(AtivoInativoEnum ativo) {
		this.ativo = ativo;
	}

	
}
