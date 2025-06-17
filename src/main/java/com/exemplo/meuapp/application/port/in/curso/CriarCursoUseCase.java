package com.exemplo.meuapp.application.port.in.curso;

import com.exemplo.meuapp.application.port.out.CursoGateways;
import com.exemplo.meuapp.domain.exception.DadosInvalidosException;
import com.exemplo.meuapp.domain.model.Curso;
public class CriarCursoUseCase {
    private CursoGateways CursoGateways;

    public CriarCursoUseCase(CursoGateways CursoGateways) {
        this.CursoGateways = CursoGateways;
    }

    public Curso criar(Curso curso) {
        if(curso.getNome() == null) throw new DadosInvalidosException(" Nome nao pode ser nulo ou vazio");
        if(curso.getDescricao() == null) throw new DadosInvalidosException(" Descricao nao pode ser nula ou vazia");
        if(curso.getCargaHoraria() == null) throw new DadosInvalidosException(" Carga horaria nao pode ser nula ou vazia");
        

        return CursoGateways.save(curso.correct());
    }
}