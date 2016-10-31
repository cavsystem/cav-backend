package br.com.cavsystem.dominio.converter;

import org.springframework.stereotype.Component;
import br.com.cavsystem.dominio.entity.Usuario;
import br.com.cavsystem.dominio.entity.dto.UsuarioDTO;

@Component
public class UsuarioConverter extends BaseConverter<Usuario, UsuarioDTO> {

	@Override
	public UsuarioDTO convertToDTO(Usuario entity) {
		return new UsuarioDTO(entity);
	}

	@Override
	public Usuario convertToEntity(UsuarioDTO dto) {
		return new Usuario(dto);
	}

}
