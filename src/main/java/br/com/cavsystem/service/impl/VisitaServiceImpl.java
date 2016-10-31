package br.com.cavsystem.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cavsystem.dominio.entity.VeiculoVisitante;
import br.com.cavsystem.dominio.entity.Visita;
import br.com.cavsystem.dominio.enums.AtivoInativoEnum;
import br.com.cavsystem.exception.BusinessException;
import br.com.cavsystem.repository.VeiculoVisitanteDAO;
import br.com.cavsystem.repository.VisitaDAO;
import br.com.cavsystem.service.VisitaService;
import br.com.cavsystem.service.VisitanteService;

@Service
@Transactional
public class VisitaServiceImpl implements VisitaService {

	@Autowired
	private VisitaDAO dao;
	
	@Autowired
	private VisitanteService visitanteService;

	@Autowired
	private VeiculoVisitanteDAO daoVeiculoVisitante;
	
	@Override
	public Visita incluir(Visita visita) throws BusinessException {				
		
		if(visita.getVeiculo() != null && visita.getVeiculo().getId() == null){
		VeiculoVisitante vv = daoVeiculoVisitante.incluir(visita.getVeiculo());	
		visita.setVeiculo(vv);	 
		}
		
		visita.setDataHoraEntrada(new Date());	
		
		return dao.incluir(visita);
	}

	@Override
	public Visita obter(Long id) throws BusinessException {
		return dao.obter(id);
	}

	@Override
	public Visita alterar(Visita visita) throws BusinessException {
		return dao.atualizar(visita);
	}

	@Override
	public void excluir(Long id) throws BusinessException {
		dao.excluir(id);
	}

	@Override
	public List<Visita> buscaVisitaPorCondominio(Long id, AtivoInativoEnum ativo) {
			return dao.buscaVisitaPorCondominio(id, ativo);
	}

	@Override
	public Visita finalizarVisitas(Visita visita) throws BusinessException {
		visita.setDataHoraSaida(new Date());
		visita.setAtivo(AtivoInativoEnum.N);
		return dao.atualizar(visita);
	}

	@Override
	public List<Visita> listaPorCondominioData(Long id, Date inicio, Date fim,
			AtivoInativoEnum liberado) {
		return dao.listaPorCondominioData(id, inicio, fim, liberado);
	}
	
	
}
