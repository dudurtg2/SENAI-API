package com.exemplo.meuapp.infrastructure.config;

import com.exemplo.meuapp.application.port.in.alunos.CriarAlunosUseCase;

import com.exemplo.meuapp.application.port.out.AlunosGateways;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AlunosConfig {
    @Bean
    public CriarAlunosUseCase criarAlunosUseCase(AlunosGateways alunosGateways) {
        return new CriarAlunosUseCase(alunosGateways);
    }
}
