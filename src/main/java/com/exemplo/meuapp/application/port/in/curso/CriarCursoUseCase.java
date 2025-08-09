package com.exemplo.meuapp.application.port.in.curso;

import com.exemplo.meuapp.application.port.out.CursoGateways;
import com.exemplo.meuapp.domain.exception.DadosInvalidosException;
import com.exemplo.meuapp.domain.model.Curso;

public class CriarCursoUseCase {
    private CursoGateways cursoGateways;

    public CriarCursoUseCase(CursoGateways cursoGateways) {
        this.cursoGateways = cursoGateways;
    }

    public Curso criar(Curso curso) {
        curso.correct();
        return cursoGateways.save(curso);
    }
}