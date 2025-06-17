package com.exemplo.meuapp.domain.model;

import java.util.UUID;

import com.exemplo.meuapp.domain.exception.DadosInvalidosException;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class Curso {

    private UUID uuid;
    private String nome;
    private String descricao;
    private String cargaHoraria;

    public Curso correct() {
        if (nome == null || nome.isBlank()) {
            throw new DadosInvalidosException("Nome nao pode ser nulo ou vazio");
        }
        if(descricao == null || descricao.isBlank()) {
            throw new DadosInvalidosException("Descricao nao pode ser nula ou vazia");
        }
        if(cargaHoraria == null || cargaHoraria.isBlank()) {
            throw new DadosInvalidosException("Carga horaria nao pode ser nula ou vazia");
        }
        return this;
    }

}
