package com.exemplo.meuapp.application.port.in.anexoEtapa;

import com.exemplo.meuapp.application.port.out.AnexoEtapaGateways;
import com.exemplo.meuapp.domain.model.Anexo;

import java.util.List;
import java.util.UUID;

public class EncontrarAnexoEtapaUseCase {
    private final AnexoEtapaGateways anexoEtapaGateways;

    public EncontrarAnexoEtapaUseCase(AnexoEtapaGateways anexoEtapaGateways) {
        this.anexoEtapaGateways = anexoEtapaGateways;
    }

    public Anexo buscarPorUuid(UUID uuid) {
        return anexoEtapaGateways.getAnexoEtapa(uuid);
    }

    public List<Anexo> buscarTodos() {
        return anexoEtapaGateways.getAllAnexosEtapa();
    }

    public List<Anexo> buscarPorEtapaId(UUID etapaId) {
        return anexoEtapaGateways.getAnexosByEtapaId(etapaId);
    }

    public List<Anexo> buscarPorEtapaIdETipo(UUID etapaId, String tipo) {
        return anexoEtapaGateways.getAnexosByEtapaIdAndTipo(etapaId, tipo);
    }
}