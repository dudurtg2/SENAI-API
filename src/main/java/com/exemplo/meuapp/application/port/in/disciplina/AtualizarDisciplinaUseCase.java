package com.exemplo.meuapp.application.port.in.disciplina;

import com.exemplo.meuapp.application.port.out.DisciplinaGateways;
import com.exemplo.meuapp.domain.model.Disciplina;
import com.exemplo.meuapp.domain.model.Disciplina;

import java.time.LocalDateTime;
import java.util.UUID;

public class AtualizarDisciplinaUseCase {
    private DisciplinaGateways disciplinaGateways;

    public AtualizarDisciplinaUseCase(DisciplinaGateways disciplinaGateways) {
        this.disciplinaGateways = disciplinaGateways;
    }

    public Disciplina atualizar(UUID uuid, Disciplina disciplina) {
        Disciplina disciplinaInDb = disciplinaGateways.getDisciplina(uuid);

        disciplinaInDb.setNome(disciplina.getNome());
        disciplinaInDb.setProfessor(disciplina.getProfessor());
        disciplinaInDb.setAtualizadoEm(LocalDateTime.now());
        return disciplinaGateways.update(disciplinaInDb);
    }
}
