package com.exemplo.meuapp.domain.model;

import lombok.*;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class DisciplinaProjeto {

    private UUID uuid;
    private Disciplina disciplina;
    private Projeto projeto;

    public DisciplinaProjeto correct() {
        if (disciplina == null) {
            throw new IllegalArgumentException("Disciplina não pode ser nula");
        }
        if (projeto == null) {
            throw new IllegalArgumentException("Projeto não pode ser nulo");
        }
        return this;
    }
}
