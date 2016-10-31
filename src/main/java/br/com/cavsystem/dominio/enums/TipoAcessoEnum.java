package br.com.cavsystem.dominio.enums;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

	@JsonIgnoreProperties(ignoreUnknown = true)
	public enum TipoAcessoEnum {

	  P("P", "A pé"), V("V", "Veículo");

	  private String valor;
	  private String descricao;

	  private TipoAcessoEnum(String valor, String descricao) {
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
	  
	  public static TipoAcessoEnum getByValor(String valor) {
		  
		  if(valor == null) {
			  return null;
		  }
		  for (TipoAcessoEnum item : TipoAcessoEnum.values()) {
			  if(item.getValor().equals(valor)) {
				  return item;
			  }
		  }
		  throw new IllegalArgumentException("Problema ao converter valor \""+valor +"\" %s para TipoAcessoEnum");
	  }
	  
	  
	}
