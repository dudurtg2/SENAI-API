package com.exemplo.meuapp.application.port.in.anexo;

import com.exemplo.meuapp.application.port.out.AnexoGateways;

import java.util.UUID;

public class DeletarAnexoUseCase {
    private final AnexoGateways anexoGateways;

    public DeletarAnexoUseCase(AnexoGateways anexoGateways) {
        this.anexoGateways = anexoGateways;
    }

    public void deletar(UUID anexoUUID) {
        anexoGateways.delete(anexoUUID);
    }
}
