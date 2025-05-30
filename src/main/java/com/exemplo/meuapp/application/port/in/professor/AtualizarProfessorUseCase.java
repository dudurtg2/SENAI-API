package com.exemplo.meuapp.application.port.in.professor;

import com.exemplo.meuapp.application.port.out.ProfessoresGateways;
import com.exemplo.meuapp.domain.model.Professores;

import java.time.LocalDateTime;
import java.util.UUID;

public class AtualizarProfessorUseCase {
    private ProfessoresGateways professoresGateways;

    public AtualizarProfessorUseCase(ProfessoresGateways professoresGateways) {
        this.professoresGateways = professoresGateways;
    }

    public Professores atualizar(UUID uuid, Professores professor) {
        Professores professorInDb = professoresGateways.getProfessoresById(uuid);

        professorInDb.setUsuariosId(professor.getUsuariosId());
        professorInDb.setEspecialidade(professor.getEspecialidade());
        professorInDb.setDepartamento(professor.getDepartamento());
        professorInDb.setTelefonePessoal(professor.getTelefonePessoal());
        professorInDb.setTelefoneProfissional(professor.getTelefoneProfissional());
        professorInDb.setLinkedin(professor.getLinkedin());
        professorInDb.setEndereco(professor.getEndereco());
        professorInDb.setStatus(professor.getStatus());
        professorInDb.setAtualizadoEm(LocalDateTime.now());
        return professoresGateways.update(professorInDb);
    }
}
