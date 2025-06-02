package com.exemplo.meuapp.application.port.in.usuarios;

import com.exemplo.meuapp.application.port.out.UsuariosGateways;
import com.exemplo.meuapp.domain.model.Usuarios;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDateTime;

public class CriarUsuariosUseCase {

    private UsuariosGateways usuariosGateways;

    public CriarUsuariosUseCase(UsuariosGateways usuariosGateways) {
        this.usuariosGateways = usuariosGateways;
    }

    public Usuarios criar(Usuarios usuarios) {
        usuarios.setCriadoEm(LocalDateTime.now());
        return usuariosGateways.save(usuarios);
    }
}
