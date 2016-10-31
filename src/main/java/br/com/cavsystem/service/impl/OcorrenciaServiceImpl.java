package br.com.cavsystem.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cavsystem.dominio.entity.Ocorrencia;
import br.com.cavsystem.exception.BusinessException;
import br.com.cavsystem.repository.OcorrenciaDAO;
import br.com.cavsystem.service.OcorrenciaService;

@Service
@Transactional
public class OcorrenciaServiceImpl implements OcorrenciaService {

	@Autowired
	private OcorrenciaDAO dao;

	@Override
	public Ocorrencia incluir(Ocorrencia ocorrencia) throws BusinessException {
		return dao.incluir(ocorrencia);
	}

	@Override
	public Ocorrencia obter(Long id) throws BusinessException {
		return dao.obter(id);
	}

	@Override
	public Ocorrencia alterar(Ocorrencia ocorrencia) throws BusinessException {
		return dao.atualizar(ocorrencia);
	}

	@Override
	public void excluir(Long id) throws BusinessException {
		dao.excluir(id);
		
	}

	@Override
	public List<Ocorrencia> listar() {
		return dao.listar();
	}

	@Override
	public List<Ocorrencia> OcorrenciaPorCondominio(Long id) {
		return dao.OcorrenciaPorCondominio(id);
	}

	

	
	
}
