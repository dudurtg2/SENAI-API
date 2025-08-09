package com.exemplo.meuapp.application.port.in.curso;

import com.exemplo.meuapp.application.port.out.CursoGateways;
import com.exemplo.meuapp.domain.model.Curso;
import java.util.List;
import java.util.UUID;

public class EncontrarCursoUseCase {
    private CursoGateways cursoGateways;

    public EncontrarCursoUseCase(CursoGateways cursoGateways) {
        this.cursoGateways = cursoGateways;
    }

    public Curso encontrarPorId(UUID id) {
        return cursoGateways.getCursoById(id);
    }

    public List<Curso> findAll() {
        return cursoGateways.getAllCursos();
    }

    public Curso findByUUID(UUID id) {
        return cursoGateways.getCursoById(id);
    }

    public Curso findByCodigo(String codigo) {
        return cursoGateways.findByCodigo(codigo);
    }

    public List<Curso> findByNivel(String nivel) {
        return cursoGateways.findByNivel(nivel);
    }

    public List<Curso> findAtivos() {
        return cursoGateways.findAtivos();
    }
}