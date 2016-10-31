package br.com.cavsystem.dominio.entity.dto;

import br.com.cavsystem.dominio.entity.Condominio;
import br.com.cavsystem.dominio.enums.AtivoInativoEnum;

public class CondominioDTO {

	private Long id;
	
	private String nome;
	
	private String cnpj;
	
	private String endereco;
	
	private String cidade;
	
	private String bairro;
	
	private String contato_1;
	
	private String contato_2;
	
	private PlanoDTO plano;

	private AtivoInativoEnum ativo;
	
	public CondominioDTO(Condominio condominio) {
		super();
		this.id = condominio.getId();
		this.nome = condominio.getNome();
		this.cnpj = condominio.getCnpj();
		this.endereco = condominio.getEndereco();
		this.cidade = condominio.getCidade();
		this.bairro = condominio.getBairro();
		this.contato_1 = condominio.getContato_1();
		this.contato_2 = condominio.getContato_2();
		this.plano = new PlanoDTO(condominio.getPlano());
		this.ativo = condominio.getAtivo();
	}

	public CondominioDTO() {
		super();
		// TODO Auto-generated constructor stub
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

	public PlanoDTO getPlano() {
		return plano;
	}

	public void setPlano(PlanoDTO plano) {
		this.plano = plano;
	}

}
