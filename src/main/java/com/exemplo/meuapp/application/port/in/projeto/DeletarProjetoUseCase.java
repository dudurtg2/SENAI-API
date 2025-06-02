package com.exemplo.meuapp.application.port.in.projeto;

import com.exemplo.meuapp.application.port.out.ProjetoGateways;

import java.util.UUID;

public class DeletarProjetoUseCase {
    private ProjetoGateways projetoGateways;

    public DeletarProjetoUseCase(ProjetoGateways projetoGateways) {
        this.projetoGateways = projetoGateways;
    }

    public void deletar(UUID uuid) {
        projetoGateways.delete(uuid);
    }
}
