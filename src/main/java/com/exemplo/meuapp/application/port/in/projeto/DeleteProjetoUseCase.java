package com.exemplo.meuapp.application.port.in.projeto;

import com.exemplo.meuapp.application.port.out.ProjetoGateways;
import com.exemplo.meuapp.domain.model.Projeto;

import java.util.UUID;

public class DeleteProjetoUseCase {
    private ProjetoGateways projetoGateways;

    public DeleteProjetoUseCase(ProjetoGateways projetoGateways) {
        this.projetoGateways = projetoGateways;
    }

    public void deletar(UUID uuid) {
        projetoGateways.delete(uuid);
    }
}
