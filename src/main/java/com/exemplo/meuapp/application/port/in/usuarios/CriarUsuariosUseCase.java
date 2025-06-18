package com.exemplo.meuapp.application.port.in.usuarios;

import com.exemplo.meuapp.application.port.out.UsuariosGateways;
import com.exemplo.meuapp.domain.enums.UsuarioTipo;
import com.exemplo.meuapp.domain.model.Usuarios;
import com.exemplo.meuapp.presentation.dto.NovoPerfil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDateTime;

public class CriarUsuariosUseCase {

    private UsuariosGateways usuariosGateways;

    public CriarUsuariosUseCase(UsuariosGateways usuariosGateways) {
        this.usuariosGateways = usuariosGateways;
    }
    private void ifExist(String email) {
        if (usuariosGateways.getUsuariosByEmail(email) != null) {
            throw new IllegalArgumentException("Usuário já existe com o email: " + email);
        }
        
    }
    public Usuarios criar(NovoPerfil usuarios) {
        ifExist(usuarios.email());
        Usuarios usuarios1 = Usuarios.builder().usuario(usuarios.usuario()).senha(usuarios.senha()).email(usuarios.email()).status(usuarios.status()).build();
        usuarios1.setTipo(UsuarioTipo.VISITANTE);
        usuarios1.setCriadoEm(LocalDateTime.now());
        return usuariosGateways.save(usuarios1);
    }

    public Usuarios criar(Usuarios usuarios) {
        ifExist(usuarios.getEmail());
        usuarios.setSenha(new BCryptPasswordEncoder().encode(usuarios.getSenha()));
        return usuariosGateways.save(usuarios);
    }
}
