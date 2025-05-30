package com.exemplo.meuapp.infrastructure.config;

import com.exemplo.meuapp.application.port.in.projetoProfessor.AtualizarProjetoProfessorUseCase;
import com.exemplo.meuapp.application.port.in.projetoProfessor.CriarProjetoProfessorUseCase;
import com.exemplo.meuapp.application.port.in.projetoProfessor.DeleteProjetoProfessorUseCase;
import com.exemplo.meuapp.application.port.in.projetoProfessor.EncontrarProjetoProfessorUseCase;
import com.exemplo.meuapp.application.port.out.ProjetoProfessorGateways;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjetoProfessorConfig {

    @Bean
    public CriarProjetoProfessorUseCase criarProjetoProfessorUseCase(ProjetoProfessorGateways projetoProfessorGateways) {
        return new CriarProjetoProfessorUseCase(projetoProfessorGateways);
    }

    @Bean
    public AtualizarProjetoProfessorUseCase atualizarProjetoProfessorUseCase(ProjetoProfessorGateways projetoProfessorGateways) {
        return new AtualizarProjetoProfessorUseCase(projetoProfessorGateways);
    }

    @Bean
    public DeleteProjetoProfessorUseCase deleteProjetoProfessorUseCase(ProjetoProfessorGateways projetoProfessorGateways) {
        return new DeleteProjetoProfessorUseCase(projetoProfessorGateways);
    }

    @Bean
    public EncontrarProjetoProfessorUseCase encontrarProjetoProfessorUseCase(ProjetoProfessorGateways projetoProfessorGateways) {
        return new EncontrarProjetoProfessorUseCase(projetoProfessorGateways);
    }


}
