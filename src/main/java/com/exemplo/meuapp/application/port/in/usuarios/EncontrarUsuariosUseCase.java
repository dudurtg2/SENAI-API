package com.exemplo.meuapp.application.port.in.usuarios;

import java.util.List;
import java.util.UUID;
import com.exemplo.meuapp.domain.enums.UsuariosStatus;
import com.exemplo.meuapp.domain.model.Usuarios;

import com.exemplo.meuapp.application.port.out.UsuariosGateways;

public class EncontrarUsuariosUseCase {

    private UsuariosGateways usuariosGateways;
    public EncontrarUsuariosUseCase(UsuariosGateways usuariosGateways) {
        this.usuariosGateways = usuariosGateways;
    }
    public Usuarios buscarPorUuid(UUID uuid) {
        return usuariosGateways.getUsuarios(uuid);
    }
    public Usuarios buscarPorMatricula(String matricula) {
        return usuariosGateways.getUsuariosByMatricula(matricula);
    }
    public List<Usuarios> buscarTodos() {
        return usuariosGateways.getAllUsuarios();
    }
    public Usuarios buscarPorEmail(String email) {
        return usuariosGateways.getUsuariosByEmail(email);
    }
    public List<Usuarios> buscarPorStatus(UsuariosStatus status) {
        return usuariosGateways.getUsuariosByStatus(status);
    }


}
