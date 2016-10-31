package br.com.cavsystem.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cavsystem.dominio.entity.Administrador;
import br.com.cavsystem.dominio.entity.Porteiro;
import br.com.cavsystem.dominio.entity.dto.CondominioDTO;
import br.com.cavsystem.dominio.enums.RoleAcesso;
import br.com.cavsystem.exception.BusinessException;
import br.com.cavsystem.repository.AdministradorDAO;
import br.com.cavsystem.repository.PorteiroDAO;
import br.com.cavsystem.service.RetornaCondominioUsuario;

@Service
@Transactional
public class RetornoCondominioUsuarioServiceImpl implements RetornaCondominioUsuario {

	@Autowired
	private AdministradorDAO dao;
	
	@Autowired
	private PorteiroDAO daoPorteiro;
	
	@Override
	public CondominioDTO condominio(String role,Long idUsuario) throws BusinessException {
		
		CondominioDTO dto = null;
		
		if(RoleAcesso.ROLE_ADMIN.name().contains(role)){
			Administrador adm =	dao.administradorPorIdUsuario(idUsuario);
			dto = new CondominioDTO(adm.getCondominio());
		}
		
		if(RoleAcesso.ROLE_PORTEIRO.name().contains(role)){
			Porteiro porteiro = daoPorteiro.porteiroPorIdUsuario(idUsuario); 
			dto = new CondominioDTO(porteiro.getCondominio());
		}
		
		if(RoleAcesso.ROLE_MORADOR.name().contains(role)){
			
		}
				
		
		return dto;
	}

	
	
	
	
	
}
