package com.exemplo.meuapp.application.port.in.unidadeCurricular;

import com.exemplo.meuapp.application.port.out.UnidadeCurricularGateways;

import java.util.UUID;

public class DeleteUnidadeCurricularUseCase {
    private UnidadeCurricularGateways unidadeCurricularGateways;

    public DeleteUnidadeCurricularUseCase(UnidadeCurricularGateways unidadeCurricularGateways) {
        this.unidadeCurricularGateways = unidadeCurricularGateways;
    }

    public void deletar(UUID uuid) {
        unidadeCurricularGateways.delete(uuid);
    }
}
