package com.exemplo.meuapp.application.port.in.endereco;

import com.exemplo.meuapp.application.port.out.EnderecoGateways;

import java.util.UUID;

public class DeleteEnderecoUseCase {
    private EnderecoGateways enderecoGateways;

    public DeleteEnderecoUseCase(EnderecoGateways enderecoGateways) {
        this.enderecoGateways = enderecoGateways;
    }

    public void deletar(UUID uuid){
        enderecoGateways.delete(uuid);
    }
}
