package com.exemplo.meuapp.infrastructure.config;

import com.exemplo.meuapp.application.port.in.usuarios.AtualizarUsuariosUseCase;
import com.exemplo.meuapp.application.port.in.usuarios.CriarUsuariosUseCase;
import com.exemplo.meuapp.application.port.in.usuarios.EncontrarUsuariosUseCase;
import com.exemplo.meuapp.application.port.out.UsuariosGateways;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsuariosConfig {
    @Bean
    public CriarUsuariosUseCase criarUsuariosUseCase(UsuariosGateways usuariosGateways) {
        return new CriarUsuariosUseCase(usuariosGateways);
    }
    @Bean
    public EncontrarUsuariosUseCase encontrarUsuariosUseCase(UsuariosGateways usuariosGateways) {
        return new EncontrarUsuariosUseCase(usuariosGateways);
    }

    @Bean
    public AtualizarUsuariosUseCase atualizarUsuariosUseCase(UsuariosGateways usuariosGateways) {
        return new AtualizarUsuariosUseCase(usuariosGateways);
    }
}
