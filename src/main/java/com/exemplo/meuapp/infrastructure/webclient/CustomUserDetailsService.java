package com.exemplo.meuapp.infrastructure.webclient;

import com.exemplo.meuapp.common.mapper.UsuariosMapper;
import com.exemplo.meuapp.infrastructure.persistence.entity.UsuariosEntity;
import com.exemplo.meuapp.infrastructure.persistence.repository.UsuariosRepository;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UsuariosRepository repo;
    private final UsuariosMapper usuariosMapper;
    public CustomUserDetailsService(UsuariosRepository repo, UsuariosMapper usuariosMapper) { this.repo = repo; this.usuariosMapper = usuariosMapper; }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UsuariosEntity user = usuariosMapper.toEntity(repo.getUsuariosByEmail(email));
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .authorities(user.getAuthorities())
                .build();
    }
}
