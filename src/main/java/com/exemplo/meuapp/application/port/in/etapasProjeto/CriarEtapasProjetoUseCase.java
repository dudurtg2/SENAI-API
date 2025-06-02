package com.exemplo.meuapp.application.port.in.etapasProjeto;

import com.exemplo.meuapp.application.port.out.EtapasProjetoGateways;
import com.exemplo.meuapp.domain.model.EtapasProjeto;

public class CriarEtapasProjetoUseCase {
    private EtapasProjetoGateways etapasProjetoGateways;

    public CriarEtapasProjetoUseCase(EtapasProjetoGateways etapasProjetoGateways) {
        this.etapasProjetoGateways = etapasProjetoGateways;
    }

    public EtapasProjeto criar(EtapasProjeto etapasProjeto) {
        return etapasProjetoGateways.save(etapasProjeto);
    }
}
