package com.exemplo.meuapp.application.port.in.unidadeCurricular;

import com.exemplo.meuapp.application.port.out.UnidadeCurricularGateways;
import com.exemplo.meuapp.domain.model.UnidadeCurricular;

import java.time.LocalDateTime;

public class CriarUnidadeCurricularUseCase {
    private UnidadeCurricularGateways unidadeCurricularGateways;

    public CriarUnidadeCurricularUseCase(UnidadeCurricularGateways unidadeCurricularGateways) {
        this.unidadeCurricularGateways = unidadeCurricularGateways;
    }

    public UnidadeCurricular criar(UnidadeCurricular unidadeCurricular) {
        unidadeCurricular.setCriadoEm(LocalDateTime.now());
        return unidadeCurricularGateways.save(unidadeCurricular);
    }
}
