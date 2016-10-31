package br.com.cavsystem.dominio.converter;

import org.springframework.stereotype.Component;
import br.com.cavsystem.dominio.entity.Apartamento;
import br.com.cavsystem.dominio.entity.dto.ApartamentoDTO;

@Component
public class ApartamentoConverter extends BaseConverter<Apartamento, ApartamentoDTO> {

	@Override
	public ApartamentoDTO convertToDTO(Apartamento entity) {
		return new ApartamentoDTO(entity);
	}

	@Override
	public Apartamento convertToEntity(ApartamentoDTO dto) {
		return new Apartamento(dto);
	}

	

	
	
}
