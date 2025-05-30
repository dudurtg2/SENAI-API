package com.exemplo.meuapp.application.port.in.professor;

import com.exemplo.meuapp.application.port.out.ProfessoresGateways;
import com.exemplo.meuapp.domain.model.Professores;

public class CriarProfessorUseCase {
    private ProfessoresGateways professoresGateways;

    public CriarProfessorUseCase(ProfessoresGateways professoresGateways) {
        this.professoresGateways = professoresGateways;
    }

    public Professores criar(Professores professores) {
        return professoresGateways.save(professores);
    }
}
