package br.com.cavsystem.exception.mensagem.adaptador;


import java.io.Serializable;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.cavsystem.exception.mensagem.Message;
import br.com.cavsystem.exception.mensagem.anotacao.CavUtilSystemInfo;
import br.com.cavsystem.exception.sistema.SystemInfo;



@Configuration
@SuppressWarnings("serial")
public abstract class AbstractExceptionAdapter implements Serializable {

	protected Message message;

	@CavUtilSystemInfo
	protected SystemInfo systemInfo; 

	public Message getMessage() {
		return message;
	}

	/**
	 * Retorna o nome do sistema.
	 *
	 * @return Nome do sistema
	 */
	@Bean
	protected String getNomeSistema() {
		if (systemInfo != null) {
			return systemInfo.getName();
		}

		return "";
	}
}
