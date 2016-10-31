package br.com.cavsystem.dominio.converter;

import org.springframework.stereotype.Component;
import br.com.cavsystem.dominio.entity.Morador;
import br.com.cavsystem.dominio.entity.dto.MoradorDTO;

@Component
public class MoradorConverter extends BaseConverter<Morador, MoradorDTO> {

	@Override
	public MoradorDTO convertToDTO(Morador entity) {
		return new MoradorDTO(entity);
	}

	@Override
	public Morador convertToEntity(MoradorDTO dto) {
		return new Morador(dto);
	}

	
}
