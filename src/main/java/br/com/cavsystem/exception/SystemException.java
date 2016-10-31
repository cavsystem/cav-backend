package br.com.cavsystem.exception;

import br.com.cavsystem.exception.mensagem.Message;
import br.com.cavsystem.exception.mensagem.Messages;


public class SystemException extends RuntimeException {

	private static final long serialVersionUID = -3705578758258584330L;
	
	private Messages messages;

	public SystemException() {
		super();
	}

	public SystemException(String message) {
		super(message);
	}

	public SystemException(Throwable cause) {
		super(cause);
	}

	public SystemException(String message, Throwable cause) {
		super(message, cause);
	}

	public SystemException(Message message) {
		this.messages = new Messages();
		this.messages.add(message);
	}

	public SystemException(Messages messages) {
		this.messages = messages;
	}

	public Messages getMessages() {
		return messages;
	}
	
	public boolean hasMessages() {
		return getMessages() != null && !getMessages().getMessages().isEmpty();
	}
}
