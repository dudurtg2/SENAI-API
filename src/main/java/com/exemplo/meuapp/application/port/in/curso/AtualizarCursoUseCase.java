package com.exemplo.meuapp.application.port.in.curso;

import com.exemplo.meuapp.application.port.out.CursoGateways;
import com.exemplo.meuapp.domain.model.Curso;

public class AtualizarCursoUseCase {
    private CursoGateways cursoGateways;

    public AtualizarCursoUseCase(CursoGateways cursoGateways) {
        this.cursoGateways = cursoGateways;
    }

    public Curso atualizar(Curso curso) {
        curso.correct();
        return cursoGateways.update(curso);
    }
}