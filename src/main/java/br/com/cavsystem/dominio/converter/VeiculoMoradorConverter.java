package br.com.cavsystem.dominio.converter;

import org.springframework.stereotype.Component;
import br.com.cavsystem.dominio.entity.VeiculoMorador;
import br.com.cavsystem.dominio.entity.dto.VeiculoMoradorDTO;

@Component
public class VeiculoMoradorConverter extends BaseConverter<VeiculoMorador, VeiculoMoradorDTO> {

	@Override
	public VeiculoMoradorDTO convertToDTO(VeiculoMorador entity) {
		return new VeiculoMoradorDTO(entity);
	}

	@Override
	public VeiculoMorador convertToEntity(VeiculoMoradorDTO dto) {
		return new VeiculoMorador(dto);
	}

	

	
}
