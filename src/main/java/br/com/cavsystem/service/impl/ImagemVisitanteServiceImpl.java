package br.com.cavsystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cavsystem.dominio.entity.ImagemVisitante;
import br.com.cavsystem.exception.BusinessException;
import br.com.cavsystem.repository.ImagemVisitanteDAO;
import br.com.cavsystem.service.ImagemVisitanteService;

@Service
@Transactional
public class ImagemVisitanteServiceImpl implements ImagemVisitanteService {

	@Autowired
	private ImagemVisitanteDAO dao;

	@Override
	public ImagemVisitante incluir(ImagemVisitante imagemVisitante)
			throws BusinessException {
		return dao.incluir(imagemVisitante);
	}

	@Override
	public ImagemVisitante obter(Long id) throws BusinessException {
		return dao.obter(id);
	}

	@Override
	public ImagemVisitante alterar(ImagemVisitante imagemVisitante)
			throws BusinessException {
		return dao.atualizar(imagemVisitante);
	}

	@Override
	public void excluir(Long id) throws BusinessException {
		dao.excluir(id);		
	}

	@Override
	public List<ImagemVisitante> listar() {
		return dao.listar();
	}

	

	@Override
	public ImagemVisitante imagemPorIdVisitante(Long id)
			throws BusinessException {		
		return dao.imagemPorIdVisitante(id);
	}
	


}
