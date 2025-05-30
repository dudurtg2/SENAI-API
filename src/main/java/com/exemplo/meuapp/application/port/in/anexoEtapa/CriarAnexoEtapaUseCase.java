package com.exemplo.meuapp.application.port.in.anexoEtapa;

import com.exemplo.meuapp.application.port.out.AnexoEtapaGateways;
import com.exemplo.meuapp.domain.model.AnexoEtapa;

public class CriarAnexoEtapaUseCase {
    private AnexoEtapaGateways anexoEtapaGateways;

    public CriarAnexoEtapaUseCase(AnexoEtapaGateways anexoEtapaGateways) {
        this.anexoEtapaGateways = anexoEtapaGateways;
    }

    public AnexoEtapa criar(AnexoEtapa anexoEtapa) {
        return anexoEtapaGateways.save(anexoEtapa);
    }
}
