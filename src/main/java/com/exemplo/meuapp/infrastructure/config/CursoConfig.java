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
    public CriarCursoUseCase criarCursoUseCase (CursoGateways CursoGateways){
        return new CriarCursoUseCase(CursoGateways);
    }

    @Bean
    public AtualizarCursoUseCase atualizarCursoUseCase (CursoGateways CursoGateways){
        return new AtualizarCursoUseCase(CursoGateways);
    }

    @Bean
    public DeletarCursoUseCase deleteCursoUseCase (CursoGateways CursoGateways){
        return new DeletarCursoUseCase(CursoGateways);
    }

    @Bean
    public EncontrarCursoUseCase encontrarCursoUseCase (CursoGateways CursoGateways){
        return new EncontrarCursoUseCase(CursoGateways);
    }
}
