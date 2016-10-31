package br.com.cavsystem.dominio.converter;

import org.springframework.stereotype.Component;
import br.com.cavsystem.dominio.entity.Cartao;
import br.com.cavsystem.dominio.entity.dto.CartaoDTO;

@Component
public class CartaoConverter extends BaseConverter<Cartao, CartaoDTO> {

	@Override
	public CartaoDTO convertToDTO(Cartao entity) {
		return new CartaoDTO(entity);
	}

	@Override
	public Cartao convertToEntity(CartaoDTO dto) {
		return new Cartao(dto);
	}

	
	
}
