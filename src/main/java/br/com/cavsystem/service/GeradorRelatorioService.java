package br.com.cavsystem.service;


import java.util.Date;
import java.util.List;

import br.com.cavsystem.dominio.entity.Correspondencia;
import br.com.cavsystem.dominio.entity.Morador;
import br.com.cavsystem.dominio.entity.VeiculoMorador;
import br.com.cavsystem.dominio.entity.Visita;
import br.com.cavsystem.exception.BusinessException;



public interface GeradorRelatorioService {
		
	byte[] gerarRelatorioMorador(List<Morador> moradores, String realPath, String usuario, String condominio) throws BusinessException;
	
	byte[] gerarRelatorioCorrespondencias(List<Correspondencia> correspondencias, String realPath, String usuario, String condominio) throws BusinessException;

	byte[] gerarRelatorioVisitas(List<Visita> Visitas, String realPath, String usuario, String condominio) throws BusinessException;
	
	byte[] gerarOcorrencia(String titulo, String realPath, String usuario, String condominio, String login, Date dataOcorrencia, Date dataCadastro,String descricao) throws BusinessException;

	byte[] gerarRelatorioVeiculoMorador(List<VeiculoMorador> veiculos, String realPath, String usuario, String condominio) throws BusinessException;

}
