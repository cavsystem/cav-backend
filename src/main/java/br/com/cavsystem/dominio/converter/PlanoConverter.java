package br.com.cavsystem.dominio.converter;

import org.springframework.stereotype.Component;
import br.com.cavsystem.dominio.entity.Plano;
import br.com.cavsystem.dominio.entity.dto.PlanoDTO;

@Component
public class PlanoConverter extends BaseConverter<Plano, PlanoDTO> {

	@Override
	public PlanoDTO convertToDTO(Plano entity) {
		return new PlanoDTO(entity);
	}

	@Override
	public Plano convertToEntity(PlanoDTO dto) {
		return new Plano(dto);
	}

	

	
	
}
