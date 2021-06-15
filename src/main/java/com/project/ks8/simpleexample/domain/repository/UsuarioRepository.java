package com.project.ks8.simpleexample.domain.repository;

import com.project.ks8.simpleexample.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByName(final String name);
}
