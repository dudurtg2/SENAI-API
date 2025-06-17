package com.exemplo.meuapp.application.port.out;

import com.exemplo.meuapp.domain.model.Curso;

import java.util.List;
import java.util.UUID;

public interface CursoGateways {
    Curso save(Curso Curso);

    Curso getCursoById(UUID CursoId);
    Curso getCursoByNome(String nome);

    void delete(UUID CursoId);

    Curso update(Curso Curso);

    List<Curso> getAllCursos();

}