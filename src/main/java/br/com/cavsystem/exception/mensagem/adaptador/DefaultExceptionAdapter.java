package br.com.cavsystem.exception.mensagem.adaptador;


import javax.transaction.SystemException;

import org.springframework.http.HttpStatus;

import br.com.cavsystem.exception.enums.ESeveridadeErro;
import br.com.cavsystem.exception.mensagem.MessageDefault;


/**
 * Adaptador para implementar o Message SystemException ou Exception.
 *
 * @author Rodrigo 
 *
 */
public class DefaultExceptionAdapter extends AbstractExceptionAdapter {

	/**
	 * serialUI.
	 */
	private static final long serialVersionUID = 76608479865656095L;

	/**
	 * Construtor padrao.
	 */
	public DefaultExceptionAdapter() {

	}

	/**
	 * Construtor depreciado para nao quebrar a pilha de injecao do CDI.
	 *
	 * @param e
	 */
	public DefaultExceptionAdapter(Exception e) {
		message = new MessageDefault();
		MessageDefault msg = (MessageDefault) message;

		msg.setSeveridade(ESeveridadeErro.SEVERIDADE_ERRO.getValor());
		msg.getMensagemErro().add(e.toString());
		msg.setCodigoErro(Integer.toString(HttpStatus.INTERNAL_SERVER_ERROR.value()));
		msg.setCategoriaErro(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
		msg.setSistema(getNomeSistema());
		msg.setOrigemErro(e.getClass().getName());
		msg.setParagrafoErro("");
		msg.setInformacoesAdicionais("");
	}

	/**
	 * Construtor depreciado para nao quebrar a pilha de injecao do CDI.
	 *
	 * @param e
	 */
	@Deprecated
	public DefaultExceptionAdapter(SystemException e) {
		message = new MessageDefault();
		MessageDefault msg = (MessageDefault) message;

		msg.setSeveridade(ESeveridadeErro.SEVERIDADE_ERRO.getValor());
		msg.getMensagemErro().add(e.toString());
		msg.setCodigoErro(Integer.toString(HttpStatus.INTERNAL_SERVER_ERROR.value()));
		msg.setCategoriaErro(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
		msg.setSistema(getNomeSistema());
		msg.setOrigemErro(e.getClass().getName());
		msg.setParagrafoErro("");
		msg.setInformacoesAdicionais("");
	}

	public void setException(Throwable e) {
		message = new MessageDefault();
		MessageDefault msg = (MessageDefault) message;

		msg.setSeveridade(ESeveridadeErro.SEVERIDADE_ERRO.getValor());
		msg.getMensagemErro().add(e.toString());
		msg.setCodigoErro(Integer.toString(HttpStatus.INTERNAL_SERVER_ERROR.value()));
		msg.setCategoriaErro(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
		msg.setSistema(getNomeSistema());
		msg.setOrigemErro(e.getClass().getName());
		msg.setParagrafoErro("");
		msg.setInformacoesAdicionais("");
	}

	public void setException(SystemException e) {
		message = new MessageDefault();
		MessageDefault msg = (MessageDefault) message;

		msg.setSeveridade(ESeveridadeErro.SEVERIDADE_ERRO.getValor());
		msg.getMensagemErro().add(e.toString());
		msg.setCodigoErro(Integer.toString(HttpStatus.INTERNAL_SERVER_ERROR.value()));
		msg.setCategoriaErro(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
		msg.setSistema(getNomeSistema());
		msg.setOrigemErro(e.getClass().getName());
		msg.setParagrafoErro("");
		msg.setInformacoesAdicionais("");
	}
}
