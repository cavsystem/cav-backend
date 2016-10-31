package br.com.cavsystem.dominio.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import br.com.cavsystem.dominio.entity.dto.AdministradorDTO;
import br.com.cavsystem.dominio.enums.AtivoInativoEnum;

@Entity
public class Administrador {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private String rg;
		
	private String cpf;
	
	private String contato_1;
	
	private String contato_2;
	
	@Enumerated(EnumType.STRING)
	private AtivoInativoEnum ativo;
	
	@ManyToOne(cascade=CascadeType.DETACH)
	private Condominio condominio;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Usuario usuario;

	public Administrador() {
		super();
	}

	public Administrador(AdministradorDTO dto) {
		super();
		this.id = dto.getId();
		this.nome = dto.getNome();
		this.rg = dto.getRg();
		this.cpf = dto.getCpf();
		this.contato_1 = dto.getContato_1();
		this.contato_2 = dto.getContato_2();
		this.condominio = new Condominio(dto.getCondominio());
		this.usuario = new Usuario(dto.getUsuario());
		this.ativo = dto.getAtivo();
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Condominio getCondominio() {
		return condominio;
	}

	public void setCondominio(Condominio condominio) {
		this.condominio = condominio;
	}

	public AtivoInativoEnum getAtivo() {
		return ativo;
	}

	public void setAtivo(AtivoInativoEnum ativo) {
		this.ativo = ativo;
	}
	
}
