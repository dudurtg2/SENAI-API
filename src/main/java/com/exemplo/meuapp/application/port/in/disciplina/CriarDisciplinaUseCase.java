package com.exemplo.meuapp.application.port.in.disciplina;

import com.exemplo.meuapp.application.port.out.DisciplinaGateways;
import com.exemplo.meuapp.domain.model.Disciplina;

public class CriarDisciplinaUseCase {
    private DisciplinaGateways disciplinaGateways;

    public CriarDisciplinaUseCase(DisciplinaGateways disciplinaGateways) {
        this.disciplinaGateways = disciplinaGateways;
    }

    public Disciplina criar(Disciplina disciplina) {
        return disciplinaGateways.save(disciplina);
    }
}
