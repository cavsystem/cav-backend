package br.com.cavsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cavsystem.dominio.entity.Usuario;

public interface UserRepository extends JpaRepository<Usuario, Long> {
	Usuario findByLogin(String username);
}