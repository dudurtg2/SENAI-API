package com.exemplo.meuapp.application.port.in.professor;

import com.exemplo.meuapp.application.port.out.ProfessoresGateways;

import java.util.UUID;

public class DeletarProfessorUseCase {
    private ProfessoresGateways professoresGateways;

    public DeletarProfessorUseCase(ProfessoresGateways professoresGateways) {
        this.professoresGateways = professoresGateways;
    }

    public void deletar(UUID uuid) {
        professoresGateways.delete(uuid);
    }
}
