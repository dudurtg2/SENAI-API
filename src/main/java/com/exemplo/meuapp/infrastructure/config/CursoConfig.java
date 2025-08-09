package com.exemplo.meuapp.infrastructure.config;

import com.exemplo.meuapp.application.port.in.curso.AtualizarCursoUseCase;
import com.exemplo.meuapp.application.port.in.curso.CriarCursoUseCase;
import com.exemplo.meuapp.application.port.in.curso.DeletarCursoUseCase;
import com.exemplo.meuapp.application.port.in.curso.EncontrarCursoUseCase;
import com.exemplo.meuapp.application.port.out.CursoGateways;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CursoConfig {

    @Bean
    public CriarCursoUseCase criarCursoUseCase(CursoGateways cursoGateways) {
        return new CriarCursoUseCase(cursoGateways);
    }

    @Bean
    public AtualizarCursoUseCase atualizarCursoUseCase(CursoGateways cursoGateways) {
        return new AtualizarCursoUseCase(cursoGateways);
    }

    @Bean
    public DeletarCursoUseCase deletarCursoUseCase(CursoGateways cursoGateways) {
        return new DeletarCursoUseCase(cursoGateways);
    }

    @Bean
    public EncontrarCursoUseCase encontrarCursoUseCase(CursoGateways cursoGateways) {
        return new EncontrarCursoUseCase(cursoGateways);
    }
}