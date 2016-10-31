package br.com.cavsystem.security;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import br.com.cavsystem.dominio.entity.Autorizacao;
import br.com.cavsystem.dominio.entity.Usuario;

public class JwtUsuarioFactory {

	 public static JwtUsuario create(Usuario user) {
	        return new JwtUsuario(
	                user.getId(),
	                user.getLogin(),
	                user.getSenha(),
	                user.isEnabled(),
	                user.getUltimaDataSenhaReset(),
	                mapToGrantedAuthorities(user.getAutorizacoes())	               
	        );
	    }

	 private static List<GrantedAuthority> mapToGrantedAuthorities(List<Autorizacao> autorizacoes) {
	        return autorizacoes.stream().map(autorizacao -> new SimpleGrantedAuthority(autorizacao.getNome().name()))
	        		.collect(Collectors.toList());
	    }
	
	
	
}
