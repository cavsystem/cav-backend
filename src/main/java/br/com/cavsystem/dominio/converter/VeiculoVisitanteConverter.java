package br.com.cavsystem.dominio.converter;

import org.springframework.stereotype.Component;
import br.com.cavsystem.dominio.entity.VeiculoVisitante;
import br.com.cavsystem.dominio.entity.dto.VeiculoVisitanteDTO;

@Component
public class VeiculoVisitanteConverter extends BaseConverter<VeiculoVisitante, VeiculoVisitanteDTO> {

	@Override
	public VeiculoVisitanteDTO convertToDTO(VeiculoVisitante entity) {
		return new VeiculoVisitanteDTO(entity);
	}

	@Override
	public VeiculoVisitante convertToEntity(VeiculoVisitanteDTO dto) {
		return new VeiculoVisitante(dto);
	}

	
	
}
