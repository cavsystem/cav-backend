package br.com.cavsystem.exception.mensagem.adaptador;



import org.springframework.http.HttpStatus;

import br.com.cavsystem.exception.SystemException;
import br.com.cavsystem.exception.enums.ESeveridadeErro;
import br.com.cavsystem.exception.mensagem.Message;
import br.com.cavsystem.exception.mensagem.MessageDefault;
import br.com.cavsystem.exception.mensagem.Messages;

/**
 * Adaptador para implementar o Message SystemException ou Exception.
 *
 * @author Rodrigo 
 *
 */
public class SystemExceptionAdapter extends AbstractExceptionAdapter {

	/**
	 * serialUI.
	 */
	private static final long serialVersionUID = -652920708462549747L;
	
	/**
	 * Lista de mensagens.
	 */
	private Messages messages;

	/**
	 * Construtor padrao.
	 */
	public SystemExceptionAdapter() {

	}

	/**
	 * Define excecao generica.
	 *
	 * @param e
	 */
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
		if (e.hasMessages()) {
			messages = e.getMessages();

			//Se as mensagens sao tipo MessageDefault, automaticamente define o nome do sistema
			for (Message message: messages.getMessages()) {
				if (message instanceof MessageDefault) {
					((MessageDefault) message).setSistema(getNomeSistema());
				}
			}
		}
	}

	public Messages getMessages() {
		return messages;
	}
}
