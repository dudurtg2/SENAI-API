package com.exemplo.meuapp.infrastructure.config;

import com.exemplo.meuapp.application.port.in.projeto.AtualizarProjetoUseCase;
import com.exemplo.meuapp.application.port.in.projetoAluno.AtualizarProjetoAlunoUseCase;
import com.exemplo.meuapp.application.port.in.projetoAluno.CriarProjetoAlunoUseCase;
import com.exemplo.meuapp.application.port.in.projetoAluno.DeleteProjetoAlunoUseCase;
import com.exemplo.meuapp.application.port.in.projetoAluno.EncontrarProjetoAlunoUseCase;
import com.exemplo.meuapp.application.port.out.ProjetoAlunoGateways;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjetoAlunoConfig {

    @Bean
    public CriarProjetoAlunoUseCase criarProjetoAlunoUseCase(ProjetoAlunoGateways projetoAlunoGateways) {
        return new CriarProjetoAlunoUseCase(projetoAlunoGateways);
    }

    @Bean
    public AtualizarProjetoAlunoUseCase atualizarProjetoAlunoUseCase(ProjetoAlunoGateways projetoAlunoGateways) {
        return new AtualizarProjetoAlunoUseCase(projetoAlunoGateways);
    }

    @Bean
    public DeleteProjetoAlunoUseCase deleteProjetoAlunoUseCase(ProjetoAlunoGateways projetoAlunoGateways) {
        return new DeleteProjetoAlunoUseCase(projetoAlunoGateways);
    }

    @Bean
    public EncontrarProjetoAlunoUseCase encontrarProjetoAlunoUseCase(ProjetoAlunoGateways projetoAlunoGateways) {
        return new EncontrarProjetoAlunoUseCase(projetoAlunoGateways);
    }


}
