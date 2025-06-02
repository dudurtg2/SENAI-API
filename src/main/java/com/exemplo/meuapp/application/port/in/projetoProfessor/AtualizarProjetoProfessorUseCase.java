package com.exemplo.meuapp.application.port.in.projetoProfessor;

import com.exemplo.meuapp.application.port.out.ProjetoProfessorGateways;
import com.exemplo.meuapp.domain.model.ProjetoProfessor;

import java.util.UUID;

public class AtualizarProjetoProfessorUseCase {
    private ProjetoProfessorGateways projetoProfessorGateways;

    public AtualizarProjetoProfessorUseCase(ProjetoProfessorGateways projetoProfessorGateways) {
        this.projetoProfessorGateways = projetoProfessorGateways;
    }

    public ProjetoProfessor atualizar(UUID uuid, ProjetoProfessor projetoProfessor) {
        ProjetoProfessor projetoProfessorInDb = projetoProfessorGateways.getProjetoProfessor(uuid);

        projetoProfessorInDb.setProjeto(projetoProfessor.getProjeto());
        projetoProfessorInDb.setProfessor(projetoProfessor.getProfessor());
        projetoProfessorInDb.setIsOrientador(projetoProfessor.getIsOrientador());

        return projetoProfessorGateways.update(projetoProfessorInDb);
    }
}
