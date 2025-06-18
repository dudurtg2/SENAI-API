package com.exemplo.meuapp.infrastructure.config;

import com.exemplo.meuapp.application.port.in.alunos.AtualizarAlunosUseCase;
import com.exemplo.meuapp.application.port.in.alunos.DeletarAlunosUseCase;
import com.exemplo.meuapp.application.port.in.alunos.EncontrarAlunosUseCase;
import com.exemplo.meuapp.application.port.out.CursoGateways;
import com.exemplo.meuapp.application.port.out.UsuariosGateways;
import com.exemplo.meuapp.common.mapper.UsuariosMapper;
import com.exemplo.meuapp.infrastructure.persistence.entity.CursoEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.exemplo.meuapp.application.port.in.alunos.CriarAlunosUseCase;
import com.exemplo.meuapp.application.port.out.AlunosGateways;

@Configuration
public class AlunosConfig {
    @Bean
    public CriarAlunosUseCase criarAlunosUseCase(AlunosGateways alunosGateways,
                                                 UsuariosGateways usuariosGateways,
                                                 UsuariosMapper usuariosMapper,
                                                 CursoGateways cursoGateways) {
        return new CriarAlunosUseCase(alunosGateways, usuariosGateways, usuariosMapper, cursoGateways);
    }

    @Bean
    public EncontrarAlunosUseCase encontrarAlunosUseCase(AlunosGateways alunosGateways) {
        return new EncontrarAlunosUseCase(alunosGateways);
    }

    @Bean
    public DeletarAlunosUseCase deletarAlunosUseCase(AlunosGateways alunosGateways) {
        return new DeletarAlunosUseCase(alunosGateways);
    }

    @Bean
    public AtualizarAlunosUseCase atualizarAlunosUseCase(AlunosGateways alunosGateways) {
        return new AtualizarAlunosUseCase(alunosGateways);
    }
}
