package br.com.cavsystem.service;

import br.com.cavsystem.dominio.entity.dto.CondominioDTO;
import br.com.cavsystem.exception.BusinessException;

public interface RetornaCondominioUsuario {

	CondominioDTO condominio(String role,Long idUsuario) throws BusinessException; 

}
