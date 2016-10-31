package br.com.cavsystem.exception.sistema;


/**
 * Define o padrao de fabrica para a construcao de objetos
 * tipo SystemInfo.
 *
 * @author Rodrigo 
 *
 */
public interface SystemInfoFactory {

	SystemInfo getSystemInfo();
}
