package com.exemplo.meuapp.application.port.in.disciplinaProjeto;

import com.exemplo.meuapp.application.port.out.DisciplinaProjetoGateways;
import com.exemplo.meuapp.domain.model.DisciplinaProjeto;

public class CriarDisciplinaProjetoUseCase {
    private DisciplinaProjetoGateways disciplinaProjetoGateways;

    public CriarDisciplinaProjetoUseCase(DisciplinaProjetoGateways disciplinaProjetoGateways) {
        this.disciplinaProjetoGateways = disciplinaProjetoGateways;
    }

    public DisciplinaProjeto criar(DisciplinaProjeto disciplinaProjeto) {
        return disciplinaProjetoGateways.save(disciplinaProjeto);
    }
}
