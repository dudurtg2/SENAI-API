package com.exemplo.meuapp.application.port.in.disciplinaProjeto;

import com.exemplo.meuapp.application.port.out.DisciplinaProjetoGateways;

import java.util.UUID;

public class DeleteDisciplinaProjetoUseCase {
    private DisciplinaProjetoGateways disciplinaProjetoGateways;

    public DeleteDisciplinaProjetoUseCase(DisciplinaProjetoGateways disciplinaProjetoGateways) {
        this.disciplinaProjetoGateways = disciplinaProjetoGateways;
    }

    public void deletar(UUID uuid) {
        disciplinaProjetoGateways.delete(uuid);
    }
}
