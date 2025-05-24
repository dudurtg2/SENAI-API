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
}
