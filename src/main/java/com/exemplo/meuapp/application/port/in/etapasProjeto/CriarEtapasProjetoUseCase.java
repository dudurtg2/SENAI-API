package com.exemplo.meuapp.application.port.in.etapasProjeto;

import com.exemplo.meuapp.application.port.out.EtapasProjetoGateways;
import com.exemplo.meuapp.domain.model.EtapasProjeto;

import java.time.LocalDateTime;

public class CriarEtapasProjetoUseCase {
    private EtapasProjetoGateways etapasProjetoGateways;

    public CriarEtapasProjetoUseCase(EtapasProjetoGateways etapasProjetoGateways) {
        this.etapasProjetoGateways = etapasProjetoGateways;
    }

    public EtapasProjeto criar(EtapasProjeto etapasProjeto) {
        etapasProjeto.setCriadoEm(LocalDateTime.now());
        return etapasProjetoGateways.save(etapasProjeto);
    }
}
