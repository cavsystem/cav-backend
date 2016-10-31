package br.com.cavsystem.dominio.enums;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

	@JsonIgnoreProperties(ignoreUnknown = true)
	public enum TipoCorrespondenciaEnum {

	  P("P", "Pacote"), E("E", "Envelope");

	  private String valor;
	  private String descricao;

	  private TipoCorrespondenciaEnum(String valor, String descricao) {
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
	  
	  public static TipoCorrespondenciaEnum getByValor(String valor) {
		  
		  if(valor == null) {
			  return null;
		  }
		  for (TipoCorrespondenciaEnum item : TipoCorrespondenciaEnum.values()) {
			  if(item.getValor().equals(valor)) {
				  return item;
			  }
		  }
		  throw new IllegalArgumentException("Problema ao converter valor \""+valor +"\" %s para TipoCorrespondenciaEnum");
	  }
	  
	  
	}
