package br.com.cavsystem.dominio.converter;

import org.springframework.stereotype.Component;
import br.com.cavsystem.dominio.entity.Visitante;
import br.com.cavsystem.dominio.entity.dto.VisitanteDTO;

@Component
public class VisitanteConverter extends BaseConverter<Visitante, VisitanteDTO> {

	@Override
	public VisitanteDTO convertToDTO(Visitante entity) {
		return new VisitanteDTO(entity);
	}

	@Override
	public Visitante convertToEntity(VisitanteDTO dto) {
		return new Visitante(dto);
	}

	
	
	
}
