package br.com.cavsystem.dominio.enums;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

	@JsonIgnoreProperties(ignoreUnknown = true)
	public enum SimNaoEnum {

	  S("S", "Sim"), N("N", "Não");

	  private String valor;
	  private String descricao;

	  private SimNaoEnum(String valor, String descricao) {
	    this.valor = valor;
	    this.descricao = descricao;
	  }

	  public String getValor() {
	    return valor;
	  }

	  public void setValor(String valor) {
	    this.valor = valor;
	  }

	  public String getDescricao() {
	    return descricao;
	  }

	  public void setDescricao(String descricao) {
	    this.descricao = descricao;
	  }
	  
	  public static SimNaoEnum getByValor(String valor) {
		  
		  if(valor == null) {
			  return null;
		  }
		  for (SimNaoEnum item : SimNaoEnum.values()) {
			  if(item.getValor().equals(valor)) {
				  return item;
			  }
		  }
		  throw new IllegalArgumentException("Problema ao converter valor \""+valor +"\" %s para SimNaoEnum");
	  }
	  
	  
	}
