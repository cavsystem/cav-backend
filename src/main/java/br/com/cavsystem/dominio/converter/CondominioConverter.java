package br.com.cavsystem.dominio.converter;

import org.springframework.stereotype.Component;

import br.com.cavsystem.dominio.entity.Condominio;
import br.com.cavsystem.dominio.entity.dto.CondominioDTO;

@Component
public class CondominioConverter extends BaseConverter<Condominio, CondominioDTO> {

	@Override
	public CondominioDTO convertToDTO(Condominio entity) {
		return new CondominioDTO(entity);
	}

	@Override
	public Condominio convertToEntity(CondominioDTO dto) {
		return new Condominio(dto);
	}

	
	
	
}
