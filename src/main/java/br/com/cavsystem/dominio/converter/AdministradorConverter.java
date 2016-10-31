package br.com.cavsystem.dominio.converter;

import org.springframework.stereotype.Component;

import br.com.cavsystem.dominio.entity.Administrador;
import br.com.cavsystem.dominio.entity.dto.AdministradorDTO;

@Component
public class AdministradorConverter extends BaseConverter<Administrador, AdministradorDTO> {

	@Override
	public AdministradorDTO convertToDTO(Administrador entity) {
		return new AdministradorDTO(entity);
	}

	@Override
	public Administrador convertToEntity(AdministradorDTO dto) {
		return new Administrador(dto);
	}

	
	
}
