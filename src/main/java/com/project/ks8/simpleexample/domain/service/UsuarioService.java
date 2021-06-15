package com.project.ks8.simpleexample.domain.service;

import com.project.ks8.simpleexample.domain.model.Usuario;
import com.project.ks8.simpleexample.domain.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public void save(final Usuario usuario) {
        var password = passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(password);
        usuarioRepository.save(usuario);
    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }
}
