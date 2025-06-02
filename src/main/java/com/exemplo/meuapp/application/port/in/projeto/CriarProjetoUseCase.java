package com.exemplo.meuapp.application.port.in.projeto;

import com.exemplo.meuapp.application.port.out.ProjetoGateways;
import com.exemplo.meuapp.domain.model.Projeto;
import com.exemplo.meuapp.domain.model.ProjetoAluno;

import java.time.LocalDateTime;

public class CriarProjetoUseCase {
    private ProjetoGateways projetosGateways;

    public CriarProjetoUseCase(ProjetoGateways projetosGateways) {
        this.projetosGateways = projetosGateways;
    }

    public Projeto criar(Projeto projeto) {
        projeto.setCriadoEm(LocalDateTime.now());
        return projetosGateways.save(projeto);
    }

}
