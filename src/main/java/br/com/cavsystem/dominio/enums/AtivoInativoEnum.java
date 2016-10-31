package br.com.cavsystem.dominio.enums;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

	@JsonIgnoreProperties(ignoreUnknown = true)
	public enum AtivoInativoEnum {

	  S("S", "Ativo"), N("N", "Inativo");

	  private String valor;
	  private String descricao;

	  private AtivoInativoEnum(String valor, String descricao) {
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
	  
	  public static AtivoInativoEnum getByValor(String valor) {
		  for (AtivoInativoEnum item : AtivoInativoEnum.values()) {
			  if(item.getValor().equals(valor)) {
				  return item;
			  }
		  }
		  throw new IllegalArgumentException(String.valueOf(valor));
	  }
	
	
}
