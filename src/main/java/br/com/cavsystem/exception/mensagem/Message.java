package br.com.cavsystem.exception.mensagem;


import java.io.Serializable;
import java.util.List;

public interface Message extends Serializable {

	String getSistema();
	
	String getOrigemErro();

	String getParagrafoErro();
	
	String getCategoriaErro();
	
	String getCodigoErro();
	
	List<String> getMensagemNegocial();
	
	List<String> getMensagemErro();
	
	int getSeveridade();
	
	String getSeveridadeDescricao();
	
	String getInformacoesAdicionais();
}
