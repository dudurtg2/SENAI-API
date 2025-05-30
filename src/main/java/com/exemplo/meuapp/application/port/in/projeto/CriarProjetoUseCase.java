package com.exemplo.meuapp.application.port.in.projeto;

import com.exemplo.meuapp.application.port.out.ProjetoGateways;
import com.exemplo.meuapp.domain.model.Projeto;

public class CriarProjetoUseCase {
    private ProjetoGateways projetosGateways;

    public CriarProjetoUseCase(ProjetoGateways projetosGateways) {
        this.projetosGateways = projetosGateways;
    }

    public Projeto criar(Projeto projeto) {
        return projetosGateways.save(projeto);
    }

}
