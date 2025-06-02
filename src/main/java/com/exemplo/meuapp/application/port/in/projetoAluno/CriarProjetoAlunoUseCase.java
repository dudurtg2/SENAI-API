package com.exemplo.meuapp.application.port.in.projetoAluno;

import com.exemplo.meuapp.application.port.out.ProjetoAlunoGateways;
import com.exemplo.meuapp.domain.model.ProjetoAluno;

public class CriarProjetoAlunoUseCase {
    private ProjetoAlunoGateways projetoAlunoGateways;

    public CriarProjetoAlunoUseCase(ProjetoAlunoGateways projetoAlunoGateways) {
        this.projetoAlunoGateways = projetoAlunoGateways;
    }

    public ProjetoAluno criar(ProjetoAluno projetoAluno) {
        return projetoAlunoGateways.save(projetoAluno);
    }
}
