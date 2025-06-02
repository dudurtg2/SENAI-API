package com.exemplo.meuapp.application.port.in.unidadeCurricular;

import com.exemplo.meuapp.application.port.out.UnidadeCurricularGateways;
import com.exemplo.meuapp.domain.model.UnidadeCurricular;

import java.time.LocalDateTime;
import java.util.UUID;

public class AtualizarUnidadeCurricularUseCase {
    private UnidadeCurricularGateways unidadeCurricularGateways;

    public AtualizarUnidadeCurricularUseCase(UnidadeCurricularGateways unidadeCurricularGateways) {
        this.unidadeCurricularGateways = unidadeCurricularGateways;
    }
    public UnidadeCurricular atualizar(UUID uuid , UnidadeCurricular unidadeCurricular) {
        UnidadeCurricular unidadeCurricularInDb = unidadeCurricularGateways.getUnidadeCurricular(uuid);
        unidadeCurricularInDb.setNome(unidadeCurricular.getNome());
        unidadeCurricularInDb.setDescricao(unidadeCurricular.getDescricao());
        unidadeCurricularInDb.setCargaHoraria(unidadeCurricular.getCargaHoraria());
        unidadeCurricularInDb.setAtualizadoEm(LocalDateTime.now());
        return unidadeCurricularGateways.update(unidadeCurricularInDb);
    }
}
