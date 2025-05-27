package com.exemplo.meuapp.domain.model;

import lombok.*;
import java.util.UUID;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class UnidadeCurricular {

    private UUID uuid;
    private String nome;
    private String descricao;
    private String cargaHoraria;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;

    public UnidadeCurricular correct() {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio");
        }
        if (descricao == null || descricao.isBlank()) {
            throw new IllegalArgumentException("Descrição não pode ser nula ou vazia");
        }
        if (cargaHoraria == null || cargaHoraria.isBlank()) {
            throw new IllegalArgumentException("Carga horária não pode ser nula ou vazia");
        }
        return this;
    }
}
