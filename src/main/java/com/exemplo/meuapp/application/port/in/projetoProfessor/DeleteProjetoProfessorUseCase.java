package com.exemplo.meuapp.application.port.in.projetoProfessor;

import com.exemplo.meuapp.application.port.out.ProjetoProfessorGateways;

import java.util.UUID;

public class DeleteProjetoProfessorUseCase {
    private ProjetoProfessorGateways projetoProfessorGateways;

    public DeleteProjetoProfessorUseCase(ProjetoProfessorGateways projetoProfessorGateways) {
        this.projetoProfessorGateways = projetoProfessorGateways;
    }

    public void deletar(UUID uuid) {
        projetoProfessorGateways.delete(uuid);
    }
}
