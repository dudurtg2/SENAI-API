package com.exemplo.meuapp.application.port.in.curso;

import com.exemplo.meuapp.application.port.out.CursoGateways;
import java.util.UUID;

public class DeletarCursoUseCase {
    private CursoGateways cursoGateways;

    public DeletarCursoUseCase(CursoGateways cursoGateways) {
        this.cursoGateways = cursoGateways;
    }

    public void deletar(UUID id) {
        cursoGateways.delete(id);
    }
}