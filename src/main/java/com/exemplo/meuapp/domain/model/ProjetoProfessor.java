package com.exemplo.meuapp.domain.model;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class ProjetoProfessor {
    private String id;
    private Projeto projeto;
    private Professores professor;
    private Boolean isOrientador;
}
