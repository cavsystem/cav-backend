package br.com.cavsystem.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.com.cavsystem.dominio.entity.Correspondencia;
import br.com.cavsystem.dominio.enums.SimNaoEnum;
import br.com.cavsystem.exception.BusinessException;
import br.com.cavsystem.repository.CorrespondenciaDAO;
import br.com.cavsystem.service.CorrespondenciaService;

@Service
@Transactional
public class CorrespondenciaServiceImpl implements CorrespondenciaService {

	@Autowired
	private CorrespondenciaDAO dao;

	@Override
	public Correspondencia incluir(Correspondencia correspondencia)
			throws BusinessException {
		return dao.incluir(correspondencia);
	}

	@Override
	public Correspondencia obter(Long id) throws BusinessException {
		return dao.obter(id);
	}

	@Override
	public Correspondencia alterar(Correspondencia correspondencia)
			throws BusinessException {
		return dao.atualizar(correspondencia);
	}

	@Override
	public void excluir(Long id) throws BusinessException {
		dao.excluir(id);		
	}

	@Override
	public List<Correspondencia> listar() {
		return dao.listar();
	}

	@Override
	public List<Correspondencia> listaPorApartamento(Long id, SimNaoEnum liberado) {
		return dao.listaPorApartamento(id,liberado);
	}

	@Override
	public void incluirLista(List<Correspondencia> correspondencias) throws BusinessException {
		List<Correspondencia> lista = new ArrayList<Correspondencia>();
		for (Correspondencia correspondencia : correspondencias) {
			correspondencia.setDataRecebimento(new Date());
			lista.add(correspondencia);
		}
		 dao.incluir(lista);
	}

	@Override
	public void alterarLista(List<Correspondencia> correspondencias)
			throws BusinessException {
		List<Correspondencia> lista = new ArrayList<Correspondencia>();
		for (Correspondencia correspondencia : correspondencias) {
			correspondencia.setDataLiberacao(new Date());
			correspondencia.setLiberado(SimNaoEnum.S);
			lista.add(correspondencia);
		}
		 dao.atualizar(lista);
		
	}

	@Override
	public List<Correspondencia> listaPorCondominioData(Long id, Date inicio,
			Date fim, SimNaoEnum liberado) {
		return dao.listaPorCondominioData(id, inicio, fim, liberado);
	}

	

	
}
