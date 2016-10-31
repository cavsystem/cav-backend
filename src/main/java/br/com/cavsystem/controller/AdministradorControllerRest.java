package br.com.cavsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cavsystem.dominio.converter.AdministradorConverter;
import br.com.cavsystem.dominio.entity.Administrador;
import br.com.cavsystem.dominio.entity.dto.AdministradorDTO;
import br.com.cavsystem.exception.BusinessException;
import br.com.cavsystem.service.AdministradorService;

@RestController
@RequestMapping("administrador")
public class AdministradorControllerRest extends RestBase<AdministradorDTO, Long>  {
	
	@Autowired
	private AdministradorService service;
	
	@Autowired
	private AdministradorConverter converter;

	@RequestMapping(value="/buscaPorCondominio/{id}", method=RequestMethod.GET)
	public ResponseEntity<List<AdministradorDTO>> buscaPorCondominio(@PathVariable Long id) throws BusinessException {
		return new ResponseEntity<List<AdministradorDTO>>(converter.convertToDTO(service.administradoresPorCondominio(id)),HttpStatus.OK);
	}
	
	@Override
	protected AdministradorDTO acaoObter(Long id) throws BusinessException {
		return  converter.convertToDTO(service.obter(id));
	}

	@Override
	protected List<AdministradorDTO> acaoListar() {
		return  converter.convertToDTO(service.listar());
	}

	@Override
	protected AdministradorDTO acaoIncluir(AdministradorDTO t)throws BusinessException {		
		Administrador adm =  service.incluir(converter.convertToEntity(t));	
		if(adm != null){
			return converter.convertToDTO(adm);
		}else{
			return null;
		}	
	}

	@Override
	protected AdministradorDTO acaoAtualizar(AdministradorDTO t)
			throws BusinessException {
		return converter.convertToDTO(service.alterar(converter.convertToEntity(t)));
	}

	@Override
	protected void acaoRemover(Long id) throws BusinessException {
		service.excluir(id);
		
	}
	

	
	
	
	
	
	
}
