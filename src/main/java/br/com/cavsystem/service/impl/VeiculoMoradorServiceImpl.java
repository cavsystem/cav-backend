package br.com.cavsystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.com.cavsystem.dominio.entity.VeiculoMorador;
import br.com.cavsystem.exception.BusinessException;
import br.com.cavsystem.repository.VeiculoMoradorDAO;
import br.com.cavsystem.service.VeiculoMoradorService;

@Service
public class VeiculoMoradorServiceImpl implements VeiculoMoradorService {

	@Autowired
	private VeiculoMoradorDAO dao;
	
	@Override
	@Transactional
	public VeiculoMorador incluir(VeiculoMorador veiculoMorador)
			throws BusinessException {
		return dao.incluir(veiculoMorador);
	}

	@Override
	public VeiculoMorador obter(Long id) throws BusinessException {
		return dao.obter(id);
	}

	@Override
	@Transactional
	public VeiculoMorador alterar(VeiculoMorador veiculoMorador)
			throws BusinessException {
		return dao.atualizar(veiculoMorador);
	}

	@Override
	@Transactional
	public void excluir(Long id) throws BusinessException {
		dao.excluir(id);
		
	}

	@Override
	public List<VeiculoMorador> listar() {
		return null;
	}

	@Override
	public List<VeiculoMorador> veiculoMoradorPorCondominio(Long id){
		return dao.veiculoMoradorPorCondominio(id);
	}

	@Override
	public List<VeiculoMorador> veiculoMoradorPorMorador(Long id) {
		return dao.veiculoMoradorPorMorador(id);
	}



	
}
