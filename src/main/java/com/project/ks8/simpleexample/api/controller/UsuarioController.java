package com.project.ks8.simpleexample.api.controller;


import com.project.ks8.simpleexample.domain.model.Usuario;
import com.project.ks8.simpleexample.domain.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody final Usuario usuario) {
        usuarioService.save(usuario);
    }

    @GetMapping
    public List<Usuario> findAll() {
        return usuarioService.findAll();
    }
}
