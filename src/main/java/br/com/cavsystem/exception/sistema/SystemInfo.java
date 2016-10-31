package br.com.cavsystem.exception.sistema;

import java.io.Serializable;

/**
 * @author Rodrigo 
 *
 */

public interface SystemInfo extends Serializable {

	/**
	 * Retorna o nome do sistema.
	 *
	 * @return Nome do sistema
	 */
	String getName();
}
