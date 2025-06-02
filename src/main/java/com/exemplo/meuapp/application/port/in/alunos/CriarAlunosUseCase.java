package com.exemplo.meuapp.application.port.in.alunos;

import com.exemplo.meuapp.application.port.out.AlunosGateways;
import com.exemplo.meuapp.domain.model.Alunos;

import java.time.LocalDateTime;

public class CriarAlunosUseCase {

    private AlunosGateways alunosGateways;

    public CriarAlunosUseCase(AlunosGateways alunosGateways) {
        this.alunosGateways = alunosGateways;
    }

    public Alunos criar(Alunos alunos) {
        alunos.setCriadoEm(LocalDateTime.now());
        return alunosGateways.save(alunos);
    }
}
