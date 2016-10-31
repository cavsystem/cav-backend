package br.com.cavsystem.dominio.converter;

import org.springframework.stereotype.Component;

import br.com.cavsystem.dominio.entity.Autorizacao;
import br.com.cavsystem.dominio.entity.dto.AutorizacaoDTO;

@Component
public class AutorizacaoConverter extends BaseConverter<Autorizacao, AutorizacaoDTO> {

	@Override
	public AutorizacaoDTO convertToDTO(Autorizacao entity) {
		return new AutorizacaoDTO(entity);
	}

	@Override
	public Autorizacao convertToEntity(AutorizacaoDTO dto) {
		return new Autorizacao(dto);
	}

	
	
	
}
