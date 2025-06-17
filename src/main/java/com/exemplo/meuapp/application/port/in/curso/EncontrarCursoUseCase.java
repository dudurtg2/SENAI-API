package com.exemplo.meuapp.application.port.in.curso;

import com.exemplo.meuapp.application.port.out.CursoGateways;
import com.exemplo.meuapp.domain.model.Curso;

import java.util.List;
import java.util.UUID;

public class EncontrarCursoUseCase {

    private final CursoGateways CursoGateways;

    public EncontrarCursoUseCase(CursoGateways CursoGateways) {
        this.CursoGateways = CursoGateways;
    }

    public Curso buscarPorUUID(UUID CursoId) {
        return CursoGateways.getCursoById(CursoId);
    }

    public Curso buscarPorNome(String nome) {
        return CursoGateways.getCursoByNome(nome);
    }

    public List<Curso> buscarTodos() {
        return CursoGateways.getAllCursos();
    }



}
