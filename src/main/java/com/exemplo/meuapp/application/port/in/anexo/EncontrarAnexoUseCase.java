package com.exemplo.meuapp.application.port.in.anexo;

import com.exemplo.meuapp.application.port.out.AnexoGateways;
import com.exemplo.meuapp.domain.model.Anexo;

import java.util.List;
import java.util.UUID;

public class EncontrarAnexoUseCase {
    private final AnexoGateways anexoGateways;

    public EncontrarAnexoUseCase(AnexoGateways anexoGateways) {
        this.anexoGateways = anexoGateways;
    }

    public Anexo buscarPorUuid(UUID uuid) {
        return anexoGateways.getAnexoEtapa(uuid);
    }

    public List<Anexo> buscarTodos() {
        return anexoGateways.getAllAnexosEtapa();
    }

    public List<Anexo> buscarPorEtapaId(UUID etapaId) {
        return anexoGateways.getAnexosByEtapaId(etapaId);
    }

    public List<Anexo> buscarPorEtapaIdETipo(UUID etapaId, String tipo) {
        return anexoGateways.getAnexosByEtapaIdAndTipo(etapaId, tipo);
    }
}