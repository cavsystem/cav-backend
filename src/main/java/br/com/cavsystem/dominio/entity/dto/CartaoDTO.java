package br.com.cavsystem.dominio.entity.dto;

import br.com.cavsystem.dominio.entity.Cartao;
import br.com.cavsystem.dominio.enums.AtivoInativoEnum;

public class CartaoDTO {
	
    private Long id;
	
	private String numero;
	
	private CondominioDTO condominio;
	
	private AtivoInativoEnum ativo;
	
	public CartaoDTO(Cartao cartao) {
		super();
		this.id = cartao.getId();
		this.numero = cartao.getNumero();
		this.ativo = cartao.getAtivo();
		this.condominio = cartao.getCondominio() != null  ? new CondominioDTO(cartao.getCondominio()): null;
	}

	public CartaoDTO() {
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
