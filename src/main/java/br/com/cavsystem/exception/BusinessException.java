package br.com.cavsystem.exception;

import br.com.cavsystem.exception.mensagem.Message;
import br.com.cavsystem.exception.mensagem.Messages;


/**
 * Representa excecao de negocio.
 * 
 * @author Rodrigo
 *
 */
public class BusinessException extends Exception {

	private Messages messages;

	private static final long serialVersionUID = 6965411093596757472L;

	public BusinessException() {
		super();
	}

	public BusinessException(String message) {
		super(message);
	}

	public BusinessException(Throwable cause) {
		super(cause);
	}

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public BusinessException(Message message) {
		this.messages = new Messages();
		this.messages.add(message);
	}

	public BusinessException(Messages messages) {
		this.messages = messages;
	}

	public Messages getMessages() {
		return messages;
	}

	public boolean hasMessages() {
		return getMessages() != null && !getMessages().getMessages().isEmpty();
	}
}
