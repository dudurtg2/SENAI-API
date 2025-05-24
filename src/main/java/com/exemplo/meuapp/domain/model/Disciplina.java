package com.exemplo.meuapp.domain.model;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class Disciplina {
    private String id;
    private String nome;
    private Professores professor;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;
}
