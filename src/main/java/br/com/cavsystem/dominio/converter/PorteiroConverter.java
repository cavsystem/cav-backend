package br.com.cavsystem.dominio.converter;

import org.springframework.stereotype.Component;
import br.com.cavsystem.dominio.entity.Porteiro;
import br.com.cavsystem.dominio.entity.dto.PorteiroDTO;

@Component
public class PorteiroConverter extends BaseConverter<Porteiro, PorteiroDTO>{

	@Override
	public PorteiroDTO convertToDTO(Porteiro entity) {
		return new PorteiroDTO(entity);
	}

	@Override
	public Porteiro convertToEntity(PorteiroDTO dto) {
		return new Porteiro(dto);
	}

}
