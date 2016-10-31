package br.com.cavsystem.dominio.converter;

import org.springframework.stereotype.Component;

import br.com.cavsystem.dominio.entity.Visita;
import br.com.cavsystem.dominio.entity.dto.VisitaDTO;

@Component
public class VisitaConverter extends BaseConverter<Visita, VisitaDTO> {

	@Override
	public VisitaDTO convertToDTO(Visita entity) {
		return new VisitaDTO(entity);
	}

	@Override
	public Visita convertToEntity(VisitaDTO dto) {
		return new Visita(dto);
	}
	
}
