package br.com.cavsystem.dominio.entity.dto;

import br.com.cavsystem.dominio.entity.Porteiro;

public class PorteiroDTO {

	private Long id;
	
	private String nome;
	
	private String rg;
	
	private String cpf;
	
	private String contato_1;
	
	private String contato_2;
	
	private CondominioDTO condominio;
	
	private UsuarioDTO usuario;;
	
	
	public PorteiroDTO(Porteiro porteiro) {
		super();
		this.id = porteiro.getId();
		this.nome = porteiro.getNome();
		this.rg = porteiro.getRg();
		this.cpf = porteiro.getCpf();
		this.contato_1 = porteiro.getContato_1();
		this.contato_2 = porteiro.getContato_2();
		this.usuario = new UsuarioDTO(porteiro.getUsuario());
		this.condominio = new CondominioDTO(porteiro.getCondominio());
	}

	public PorteiroDTO() {
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

	
}
