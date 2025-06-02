package com.exemplo.meuapp.application.port.in.projetoAluno;

import com.exemplo.meuapp.application.port.out.ProjetoAlunoGateways;
import com.exemplo.meuapp.domain.model.ProjetoAluno;

import java.util.UUID;

public class AtualizarProjetoAlunoUseCase {
    private ProjetoAlunoGateways projetoAlunoGateways;

    public AtualizarProjetoAlunoUseCase(ProjetoAlunoGateways projetoAlunoGateways) {
        this.projetoAlunoGateways = projetoAlunoGateways;
    }

    public ProjetoAluno atualizar(UUID uuid,ProjetoAluno projetoAluno) {
        ProjetoAluno projetoAlunoInDb = projetoAlunoGateways.getProjetoAluno(uuid);
        projetoAlunoInDb.setProjeto(projetoAluno.getProjeto());
        projetoAlunoInDb.setAluno(projetoAluno.getAluno());
        return projetoAlunoGateways.update(projetoAlunoInDb);
    }
}
