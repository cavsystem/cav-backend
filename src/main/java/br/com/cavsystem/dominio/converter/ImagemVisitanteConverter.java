package br.com.cavsystem.dominio.converter;

import org.springframework.stereotype.Component;
import br.com.cavsystem.dominio.entity.ImagemVisitante;
import br.com.cavsystem.dominio.entity.dto.ImagemVisitanteDTO;

@Component
public class ImagemVisitanteConverter extends BaseConverter<ImagemVisitante, ImagemVisitanteDTO> {

	@Override
	public ImagemVisitanteDTO convertToDTO(ImagemVisitante entity) {
		return new ImagemVisitanteDTO(entity);
	}

	@Override
	public ImagemVisitante convertToEntity(ImagemVisitanteDTO dto) {
		return new ImagemVisitante(dto);
	}

	
	
	
}
