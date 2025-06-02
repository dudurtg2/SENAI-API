package com.exemplo.meuapp.application.port.in.professor;

import com.exemplo.meuapp.application.port.out.ProfessoresGateways;
import com.exemplo.meuapp.domain.model.Professores;

import java.time.LocalDateTime;

public class CriarProfessorUseCase {
    private ProfessoresGateways professoresGateways;

    public CriarProfessorUseCase(ProfessoresGateways professoresGateways) {
        this.professoresGateways = professoresGateways;
    }

    public Professores criar(Professores professores) {
        professores.setCriadoEm(LocalDateTime.now());
        return professoresGateways.save(professores);
    }
}
