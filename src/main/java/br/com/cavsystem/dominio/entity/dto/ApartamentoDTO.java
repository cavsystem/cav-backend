package br.com.cavsystem.dominio.entity.dto;

import br.com.cavsystem.dominio.entity.Apartamento;


public class ApartamentoDTO {
	
	private Long id;
	
	private String nome;
	
	private String bloco;
	
	private String telefone;
	
	private CondominioDTO condominio;
	
	public ApartamentoDTO(Apartamento ap) {
		super();
		this.id = ap.getId();
		this.nome = ap.getNome();
		this.bloco = ap.getBloco();
		this.telefone = ap.getTelefone();
		this.condominio = ap.getCondominio() != null ? new CondominioDTO(ap.getCondominio()) : null;
	}

	public ApartamentoDTO() {
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

	public CondominioDTO getCondominio() {
		return condominio;
	}

	public void setCondominio(CondominioDTO condominio) {
		this.condominio = condominio;
	}

	public String getBloco() {
		return bloco;
	}

	public void setBloco(String bloco) {
		this.bloco = bloco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
	
}
