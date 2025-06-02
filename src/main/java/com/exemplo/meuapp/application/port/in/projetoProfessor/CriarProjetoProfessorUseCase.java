package com.exemplo.meuapp.application.port.in.projetoProfessor;

import com.exemplo.meuapp.application.port.out.ProjetoProfessorGateways;
import com.exemplo.meuapp.domain.model.ProjetoProfessor;

public class CriarProjetoProfessorUseCase {
    private ProjetoProfessorGateways projetoProfessorGateways;

    public CriarProjetoProfessorUseCase(ProjetoProfessorGateways projetoProfessorGateways) {
        this.projetoProfessorGateways = projetoProfessorGateways;
    }

    public ProjetoProfessor criar(ProjetoProfessor projetoProfessor) {
        return projetoProfessorGateways.save(projetoProfessor);
    }

}
