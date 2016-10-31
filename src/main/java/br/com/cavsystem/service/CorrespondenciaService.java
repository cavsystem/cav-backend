package br.com.cavsystem.service;

import java.util.Date;
import java.util.List;
import br.com.cavsystem.dominio.entity.Correspondencia;
import br.com.cavsystem.dominio.enums.SimNaoEnum;
import br.com.cavsystem.exception.BusinessException;

public interface CorrespondenciaService {

	Correspondencia incluir(Correspondencia correspondencia) throws BusinessException;
	
	void incluirLista(List<Correspondencia> correspondencias) throws BusinessException;
	
	void alterarLista(List<Correspondencia> correspondencias) throws BusinessException;
	
	Correspondencia obter(Long id) throws BusinessException;
	
	Correspondencia alterar(Correspondencia correspondencia) throws BusinessException;
	
	void excluir(Long id) throws BusinessException;	
	
	List<Correspondencia> listar();
	
	List<Correspondencia> listaPorApartamento(Long id,SimNaoEnum liberado);
		
	List<Correspondencia> listaPorCondominioData(Long id,Date inicio,Date fim,SimNaoEnum liberado);

}
