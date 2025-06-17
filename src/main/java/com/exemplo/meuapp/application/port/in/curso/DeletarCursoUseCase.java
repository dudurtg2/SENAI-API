package com.exemplo.meuapp.application.port.in.curso;

import com.exemplo.meuapp.application.port.out.CursoGateways;

import java.util.UUID;

public class DeletarCursoUseCase {
    private CursoGateways CursoGateways;

    public DeletarCursoUseCase(CursoGateways CursoGateways) {
        this.CursoGateways = CursoGateways;
    }

    public void deletar(UUID uuid) {
        CursoGateways.delete(uuid);
    }
}