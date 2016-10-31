package br.com.cavsystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.com.cavsystem.dominio.entity.VeiculoVisitante;
import br.com.cavsystem.exception.BusinessException;
import br.com.cavsystem.repository.VeiculoVisitanteDAO;
import br.com.cavsystem.service.VeiculoVisitanteService;

@Service
@Transactional
public class VeiculoVisitanteServiceImpl implements VeiculoVisitanteService {

	@Autowired
	private VeiculoVisitanteDAO dao;

	@Override
	public VeiculoVisitante incluir(VeiculoVisitante veiculoVisitante)throws BusinessException {
		return dao.incluir(veiculoVisitante);
	}

	@Override
	public VeiculoVisitante obter(Long id) throws BusinessException {
		return dao.obter(id);
	}

	@Override
	public VeiculoVisitante alterar(VeiculoVisitante veiculoVisitante)
			throws BusinessException {
		
		return dao.atualizar(veiculoVisitante);
	}

	@Override
	public void excluir(Long id) throws BusinessException {
		dao.excluir(id);
		
	}

	@Override
	public List<VeiculoVisitante> listar() {
		return null;
	}

	@Override
	public List<VeiculoVisitante> VeiculoVisitantePorCondominio(Long id) {
		return null;
	}

	@Override
	public List<VeiculoVisitante> VeiculoVisitantePorVisitante(Long id) {
		return dao.VeiculoVisitantePorVisitante(id);
	}
	
	
}
