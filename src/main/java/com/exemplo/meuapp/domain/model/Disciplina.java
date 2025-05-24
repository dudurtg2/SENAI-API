package com.exemplo.meuapp.domain.model;

import lombok.*;
import java.util.UUID;
import java.util.UUID;
import java.util.UUID;
import java.util.UUID;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class Disciplina {

    private UUID uuid;
    private String nome;
    private Professores professor;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;
}
