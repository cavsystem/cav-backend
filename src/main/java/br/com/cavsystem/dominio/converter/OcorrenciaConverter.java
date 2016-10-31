package br.com.cavsystem.dominio.converter;

import org.springframework.stereotype.Component;
import br.com.cavsystem.dominio.entity.Ocorrencia;
import br.com.cavsystem.dominio.entity.dto.OcorrenciaDTO;

@Component
public class OcorrenciaConverter extends BaseConverter<Ocorrencia, OcorrenciaDTO> {

	@Override
	public OcorrenciaDTO convertToDTO(Ocorrencia entity) {
		return new OcorrenciaDTO(entity);
	}

	@Override
	public Ocorrencia convertToEntity(OcorrenciaDTO dto) {
		return new Ocorrencia(dto);
	}

	

}
