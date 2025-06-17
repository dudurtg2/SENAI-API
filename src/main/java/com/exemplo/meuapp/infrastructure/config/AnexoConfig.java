package com.exemplo.meuapp.infrastructure.config;

import com.exemplo.meuapp.application.port.in.anexo.AtualizarAnexoUseCase;
import com.exemplo.meuapp.application.port.in.anexo.CriarAnexoUseCase;
import com.exemplo.meuapp.application.port.in.anexo.DeletarAnexoUseCase;
import com.exemplo.meuapp.application.port.in.anexo.EncontrarAnexoUseCase;
import com.exemplo.meuapp.application.port.out.AnexoGateways;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnexoConfig {

    @Bean
    public CriarAnexoUseCase criarAnexoEtapaUseCase(AnexoGateways anexoGateways) {
        return new CriarAnexoUseCase(anexoGateways);
    }

    @Bean
    public EncontrarAnexoUseCase encontrarAnexoEtapaUseCase(AnexoGateways anexoGateways) {
        return new EncontrarAnexoUseCase(anexoGateways);
    }

    @Bean
    public AtualizarAnexoUseCase atualizarAnexoEtapaUseCase(AnexoGateways anexoGateways) {
        return new AtualizarAnexoUseCase(anexoGateways);
    }

    @Bean
    public DeletarAnexoUseCase deletarAnexoEtapaUseCase (AnexoGateways anexoGateways) {
        return new DeletarAnexoUseCase(anexoGateways);
    }
}
