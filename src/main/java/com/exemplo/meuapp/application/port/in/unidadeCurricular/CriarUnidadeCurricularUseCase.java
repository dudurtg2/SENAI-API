package com.exemplo.meuapp.application.port.in.unidadeCurricular;

import com.exemplo.meuapp.application.port.out.UnidadeCurricularGateways;
import com.exemplo.meuapp.domain.model.UnidadeCurricular;

public class CriarUnidadeCurricularUseCase {
    private UnidadeCurricularGateways unidadeCurricularGateways;

    public CriarUnidadeCurricularUseCase(UnidadeCurricularGateways unidadeCurricularGateways) {
        this.unidadeCurricularGateways = unidadeCurricularGateways;
    }

    public UnidadeCurricular criar(UnidadeCurricular unidadeCurricular) {
        return unidadeCurricularGateways.save(unidadeCurricular);
    }
}
