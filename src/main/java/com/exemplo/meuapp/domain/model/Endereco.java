package com.exemplo.meuapp.domain.model;

import lombok.*;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class Endereco {

    private UUID uuid;
    private String cep;
    private String logradouro;
    private int numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String pais;

    public Endereco correct() {
        if (cep == null || cep.isBlank()) {
            throw new IllegalArgumentException("CEP não pode ser nulo ou vazio");
        }
        if (logradouro == null || logradouro.isBlank()) {
            throw new IllegalArgumentException("Logradouro não pode ser nulo ou vazio");
        }
        if (numero <= 0) {
            throw new IllegalArgumentException("Número deve ser maior que zero");
        }
        if (bairro == null || bairro.isBlank()) {
            throw new IllegalArgumentException("Bairro não pode ser nulo ou vazio");
        }
        if (cidade == null || cidade.isBlank()) {
            throw new IllegalArgumentException("Cidade não pode ser nula ou vazia");
        }
        if (estado == null || estado.isBlank()) {
            throw new IllegalArgumentException("Estado não pode ser nulo ou vazio");
        }
        if (pais == null || pais.isBlank()) {
            throw new IllegalArgumentException("País não pode ser nulo ou vazio");
        }
        return this;
    }

}
