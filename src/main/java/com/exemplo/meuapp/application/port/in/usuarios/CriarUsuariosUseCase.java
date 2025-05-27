package com.exemplo.meuapp.application.port.in.usuarios;

import com.exemplo.meuapp.application.port.out.UsuariosGateways;
import com.exemplo.meuapp.domain.model.Usuarios;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CriarUsuariosUseCase {

    private UsuariosGateways usuariosGateways;

    public CriarUsuariosUseCase(UsuariosGateways usuariosGateways) {
        this.usuariosGateways = usuariosGateways;
    }

    public Usuarios criar(Usuarios usuarios) {
        usuarios.setSenha(new BCryptPasswordEncoder().encode(usuarios.getSenha()));
        return usuariosGateways.save(usuarios);
    }
}
