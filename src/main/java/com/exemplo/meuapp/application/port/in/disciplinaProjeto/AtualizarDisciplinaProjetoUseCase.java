package com.exemplo.meuapp.application.port.in.disciplinaProjeto;

import com.exemplo.meuapp.application.port.out.DisciplinaProjetoGateways;
import com.exemplo.meuapp.domain.model.DisciplinaProjeto;

import java.util.UUID;

public class AtualizarDisciplinaProjetoUseCase {
    private DisciplinaProjetoGateways disciplinaProjetoGateways;

    public AtualizarDisciplinaProjetoUseCase(DisciplinaProjetoGateways disciplinaProjetoGateways) {
        this.disciplinaProjetoGateways = disciplinaProjetoGateways;
    }

    public DisciplinaProjeto atualizar(UUID uuid,DisciplinaProjeto disciplinaProjeto) {
        DisciplinaProjeto disciplinaProjetoInDb = disciplinaProjetoGateways.getDisciplinaProjeto(uuid);

        disciplinaProjetoInDb.setDisciplina(disciplinaProjeto.getDisciplina());
        disciplinaProjetoInDb.setProjeto(disciplinaProjeto.getProjeto());

        return disciplinaProjetoGateways.update(disciplinaProjetoInDb);
    }
}
