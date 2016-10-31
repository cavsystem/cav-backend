package br.com.cavsystem.dominio.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.cavsystem.dominio.entity.dto.CondominioDTO;
import br.com.cavsystem.dominio.enums.AtivoInativoEnum;

@Entity
public class Condominio {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private String cnpj;
	
	private String endereco;
	
	private String cidade;
	
	private String bairro;
	
	private String contato_1;
	
	private String contato_2;
	
	@ManyToOne(cascade=CascadeType.DETACH)
	private Plano plano;
	
	@Enumerated(EnumType.STRING)
	private AtivoInativoEnum ativo;
	
	public Condominio(CondominioDTO dto) {
		super();
		this.id = dto.getId();
		this.nome = dto.getNome();
		this.cnpj = dto.getCnpj();
		this.endereco = dto.getEndereco();
		this.cidade = dto.getCidade();
		this.bairro = dto.getBairro();
		this.contato_1 = dto.getContato_1();
		this.contato_2 = dto.getContato_2();
		this.plano = new Plano(dto.getPlano());
		this.ativo = dto.getAtivo();		
	}

	public Condominio() {
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

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
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

	public AtivoInativoEnum getAtivo() {
		return ativo;
	}

	public void setAtivo(AtivoInativoEnum ativo) {
		this.ativo = ativo;
	}

	public Plano getPlano() {
		return plano;
	}

	public void setPlano(Plano plano) {
		this.plano = plano;
	}
	
	
}
