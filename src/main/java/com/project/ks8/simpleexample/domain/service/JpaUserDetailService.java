package com.project.ks8.simpleexample.domain.service;

import com.project.ks8.simpleexample.domain.model.Usuario;
import com.project.ks8.simpleexample.domain.repository.UsuarioRepository;
import com.project.ks8.simpleexample.infra.AuthUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JpaUserDetailService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByName(s)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario não encontrado."));

        return new AuthUser(usuario, getAuthorities());
    }

    public Collection<GrantedAuthority>  getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ADMIN"));
    }
}
