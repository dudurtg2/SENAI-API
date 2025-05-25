package com.exemplo.meuapp.domain.model;

import lombok.*;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class ProjetoProfessor {

    private UUID uuid;
    private Projeto projeto;
    private Professores professor;
    private Boolean isOrientador;

    public ProjetoProfessor correct() {
        if (projeto == null) {
            throw new IllegalArgumentException("Projeto não pode ser nulo");
        }
        if (professor == null) {
            throw new IllegalArgumentException("Professor não pode ser nulo");
        }
        if(isOrientador == null) {
            throw new IllegalArgumentException("isOrientador não pode ser nulo");
        }
        return this;
    }
}
