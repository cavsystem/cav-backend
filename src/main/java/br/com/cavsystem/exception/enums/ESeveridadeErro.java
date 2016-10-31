package br.com.cavsystem.exception.enums;

public enum ESeveridadeErro {
	
	SEVERIDADE_FATAL("Fatal",0),
	SEVERIDADE_ERRO("Erro",1),	
	SEVERIDADE_AVISO("Aviso",2),
	SEVERIDADE_INFORMACAO("Informa��o",3),
	SEVERIDADE_SUCESSO("Sucesso",4);
	
	//Definicao das constantes
	private final String descricao;
	
	private final int valor;
	
	//método que define as constantes
	private ESeveridadeErro(String descricao, int valor){
		this.descricao = descricao;
		this.valor = valor;
	}
	
	//GET e SET
	
	public String getDescricao() {
		return descricao;
	}
	
	public int getValor() {
		return valor;
	}

}
