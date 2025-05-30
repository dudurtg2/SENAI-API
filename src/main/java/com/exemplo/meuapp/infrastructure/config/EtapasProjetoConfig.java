package com.exemplo.meuapp.infrastructure.config;

import com.exemplo.meuapp.application.port.in.etapasProjeto.AtualizarEtapasProjetoUseCase;
import com.exemplo.meuapp.application.port.in.etapasProjeto.CriarEtapasProjetoUseCase;
import com.exemplo.meuapp.application.port.in.etapasProjeto.DeleteEtapasProjetoUseCase;
import com.exemplo.meuapp.application.port.in.etapasProjeto.EncontrarEtapasProjetoUseCase;
import com.exemplo.meuapp.application.port.out.EtapasProjetoGateways;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EtapasProjetoConfig {

    @Bean
    public CriarEtapasProjetoUseCase criarEtapasProjetoUseCase(EtapasProjetoGateways etapasProjetoGateways){
        return new CriarEtapasProjetoUseCase(etapasProjetoGateways);
    }

    @Bean
    public AtualizarEtapasProjetoUseCase atualizarEtapasProjetoUseCase(EtapasProjetoGateways etapasProjetoGateways){
        return new AtualizarEtapasProjetoUseCase(etapasProjetoGateways);
    }

    @Bean
    public DeleteEtapasProjetoUseCase deleteEtapasProjetoUseCase(EtapasProjetoGateways etapasProjetoGateways){
        return new DeleteEtapasProjetoUseCase(etapasProjetoGateways);
    }

    @Bean
    public EncontrarEtapasProjetoUseCase encontrarEtapasProjetoUseCase(EtapasProjetoGateways etapasProjetoGateways){
        return new EncontrarEtapasProjetoUseCase(etapasProjetoGateways);
    }
}
