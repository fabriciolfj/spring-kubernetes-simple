package com.project.ks8.simpleexample.infra;

import com.project.ks8.simpleexample.domain.model.Usuario;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter
public class AuthUser extends User {

    private Long userId;
    private String name;

    public AuthUser(Usuario usuario, Collection<? extends GrantedAuthority> authorities) {
        super(usuario.getName(), usuario.getPassword(), authorities);

        this.name = usuario.getName();
        this.userId = usuario.getId();
    }
}
