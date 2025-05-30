package com.exemplo.meuapp.application.port.in.endereco;

import com.exemplo.meuapp.application.port.out.EnderecoGateways;
import com.exemplo.meuapp.domain.model.Endereco;

public class CriarEnderecoUseCase {
    private EnderecoGateways enderecoGateways;

    public CriarEnderecoUseCase(EnderecoGateways enderecoGateways) {
        this.enderecoGateways = enderecoGateways;
    }
    public Endereco criar(Endereco endereco) {
        return enderecoGateways.save(endereco);
    }
}
