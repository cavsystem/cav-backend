package br.com.cavsystem.dominio.converter;

import org.springframework.stereotype.Component;
import br.com.cavsystem.dominio.entity.Correspondencia;
import br.com.cavsystem.dominio.entity.dto.CorrespondeciaDTO;

@Component
public class CorrespondenciaConverter extends BaseConverter<Correspondencia, CorrespondeciaDTO> {

	@Override
	public CorrespondeciaDTO convertToDTO(Correspondencia entity) {
		return new CorrespondeciaDTO(entity);
	}

	@Override
	public Correspondencia convertToEntity(CorrespondeciaDTO dto) {
		return new Correspondencia(dto);
	}

	
	
	
}
