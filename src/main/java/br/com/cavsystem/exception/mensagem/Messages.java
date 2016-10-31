package br.com.cavsystem.exception.mensagem;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Messages implements Serializable {

	private static final long serialVersionUID = -8913132035819538783L;

	private List<Message> messages;
	
	public Messages add(Message message) {
		if (messages == null) {
			messages = new ArrayList<Message>();
		}
		
		messages.add(message);
		
		return this;
	}
	
	public List<Message> getMessages() {
		return messages;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
}
