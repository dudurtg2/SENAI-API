package com.exemplo.meuapp.application.port.out;

import com.exemplo.meuapp.domain.model.Curso;

import java.util.List;
import java.util.UUID;

public interface CursoGateways {
     Curso save(Curso curso);
     Curso getCursoById(UUID cursoId);
     void delete(UUID cursoId);
     Curso update(Curso curso);
     List<Curso> getAllCursos();
     Curso findByCodigo(String codigo);
     List<Curso> findByNivel(String nivel);
     List<Curso> findAtivos();
}