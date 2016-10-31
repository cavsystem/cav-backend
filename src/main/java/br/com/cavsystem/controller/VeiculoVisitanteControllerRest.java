package br.com.cavsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cavsystem.dominio.converter.VeiculoVisitanteConverter;
import br.com.cavsystem.dominio.entity.VeiculoVisitante;
import br.com.cavsystem.dominio.entity.dto.VeiculoVisitanteDTO;
import br.com.cavsystem.dominio.enums.AtivoInativoEnum;
import br.com.cavsystem.exception.BusinessException;
import br.com.cavsystem.service.VeiculoVisitanteService;

@RestController
@RequestMapping("veiculoVisitante")
public class VeiculoVisitanteControllerRest extends RestBase<VeiculoVisitanteDTO, Long>  {
	
	@Autowired
	private VeiculoVisitanteService service;
	
	@Autowired
	private VeiculoVisitanteConverter converter;
	

	@RequestMapping(value="/veiculoPorVisitante/{id}" , method=RequestMethod.GET)
	public List<VeiculoVisitanteDTO> listarVeiculoMoradorPorCondominio(@PathVariable Long id){
		return converter.convertToDTO(service.VeiculoVisitantePorVisitante(id));
	}

	@Override
	protected VeiculoVisitanteDTO acaoObter(Long id) throws BusinessException {
		return converter.convertToDTO(service.obter(id));
	}

	@Override
	protected List<VeiculoVisitanteDTO> acaoListar() {
		return null;
	}


	@Override
	protected VeiculoVisitanteDTO acaoIncluir(VeiculoVisitanteDTO t)
			throws BusinessException {
		t.setAtivo(AtivoInativoEnum.S);
		return converter.convertToDTO(service.incluir(converter.convertToEntity(t)));
	}


	@Override
	protected VeiculoVisitanteDTO acaoAtualizar(VeiculoVisitanteDTO t)
			throws BusinessException {
		return converter.convertToDTO(service.alterar(converter.convertToEntity(t)));
	}


	@Override
	protected void acaoRemover(Long id) throws BusinessException {
		VeiculoVisitante vv = service.obter(id);
		vv.setAtivo(AtivoInativoEnum.N);
		service.alterar(vv);
	}
	
	
}
