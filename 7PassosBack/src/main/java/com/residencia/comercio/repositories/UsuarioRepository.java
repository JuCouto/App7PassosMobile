package com.residencia.comercio.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.residencia.comercio.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	Optional<Usuario> findByEmail(String email);
}
