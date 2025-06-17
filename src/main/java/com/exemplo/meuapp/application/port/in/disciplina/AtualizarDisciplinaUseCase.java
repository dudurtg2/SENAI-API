package com.exemplo.meuapp.application.port.in.disciplina;

import com.exemplo.meuapp.application.port.out.DisciplinaGateways;
import com.exemplo.meuapp.domain.exception.DadosInvalidosException;
import com.exemplo.meuapp.domain.exception.RegraDeNegocioException;
import com.exemplo.meuapp.domain.model.Disciplina;

import java.time.LocalDateTime;
import java.util.UUID;

public class AtualizarDisciplinaUseCase {
    private final DisciplinaGateways disciplinaGateways;

    public AtualizarDisciplinaUseCase(DisciplinaGateways disciplinaGateways) {
        this.disciplinaGateways = disciplinaGateways;
    }

    public Disciplina atualizar(UUID uuid, Disciplina disciplina) {
        Disciplina disciplinaInDb = disciplinaGateways.getDisciplina(uuid);
        if (disciplinaInDb == null) {
            throw new RegraDeNegocioException("Disciplina não encontrada.");
        }

        if (!disciplinaInDb.getNome().equalsIgnoreCase(disciplina.getNome()) &&
                disciplinaGateways.existsByNome(disciplina.getNome())) {
            throw new RegraDeNegocioException("Já existe uma disciplina com este nome.");
        }

        if (disciplina.getProfessor() != null && disciplina.getProfessor().getStatus() != null) {
            if (!disciplina.getProfessor().getStatus().name().equals("ATIVO")) {
                throw new RegraDeNegocioException("Professor associado está inativo.");
            }
        }
        disciplinaInDb.setDescricao(disciplina.getDescricao());
        disciplinaInDb.setCargaHoraria(disciplina.getCargaHoraria());
    
        disciplinaInDb.setNome(disciplina.getNome());
        disciplinaInDb.setProfessor(disciplina.getProfessor());
        disciplinaInDb.setAtualizadoEm(LocalDateTime.now());
        return disciplinaGateways.update(disciplinaInDb);
    }
}