package br.com.cavsystem.dominio.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.cavsystem.dominio.entity.dto.CartaoDTO;
import br.com.cavsystem.dominio.enums.AtivoInativoEnum;

@Entity
public class Cartao {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String numero;
	
	@ManyToOne(cascade=CascadeType.DETACH)
	private Condominio condominio;
	
	@Enumerated(EnumType.STRING)
	private AtivoInativoEnum ativo;
	
	public Cartao(CartaoDTO dto) {
		super();
		this.id = dto.getId();
		this.numero = dto.getNumero();
		this.ativo = dto.getAtivo();
		this.condominio = dto.getCondominio() != null ? new Condominio(dto.getCondominio()) : null;
	}

	public Cartao() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
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
