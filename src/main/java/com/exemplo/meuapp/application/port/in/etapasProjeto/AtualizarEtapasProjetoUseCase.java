package com.exemplo.meuapp.application.port.in.etapasProjeto;

import com.exemplo.meuapp.application.port.out.EtapasProjetoGateways;
import com.exemplo.meuapp.domain.model.EtapasProjeto;

import java.time.LocalDateTime;
import java.util.UUID;

public class AtualizarEtapasProjetoUseCase {
    private EtapasProjetoGateways etapasProjetoGateways;

    public AtualizarEtapasProjetoUseCase(EtapasProjetoGateways etapasProjetoGateways) {
        this.etapasProjetoGateways = etapasProjetoGateways;
    }

    public EtapasProjeto atualizar(UUID uuid , EtapasProjeto etapasProjeto) {
        EtapasProjeto etapasProjetoInDb = etapasProjetoGateways.getEtapaById(uuid);

        etapasProjetoInDb.setProjeto(etapasProjeto.getProjeto());
        etapasProjetoInDb.setNomeEtapa(etapasProjeto.getNomeEtapa());
        etapasProjetoInDb.setDescricao(etapasProjeto.getDescricao());
        etapasProjetoInDb.setOrdem(etapasProjeto.getOrdem());
        etapasProjetoInDb.setStatus(etapasProjeto.getStatus());
        etapasProjetoInDb.setAtualizadoEm(LocalDateTime.now());
        return etapasProjetoGateways.update(etapasProjetoInDb);
    }
}
