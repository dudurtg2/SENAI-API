package com.exemplo.meuapp.application.port.in.etapasProjeto;

import com.exemplo.meuapp.application.port.out.EtapasProjetoGateways;

import java.util.UUID;

public class DeleteEtapasProjetoUseCase {
    private EtapasProjetoGateways etapasProjetoGateways;

    public DeleteEtapasProjetoUseCase(EtapasProjetoGateways etapasProjetoGateways) {
        this.etapasProjetoGateways = etapasProjetoGateways;
    }

    public void deletar(UUID uuid) {
        etapasProjetoGateways.delete(uuid);
    }
}
