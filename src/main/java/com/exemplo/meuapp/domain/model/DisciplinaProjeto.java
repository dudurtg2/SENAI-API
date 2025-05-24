package com.exemplo.meuapp.domain.model;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class DisciplinaProjeto {
    private String id;
    private Disciplina disciplina;
    private Projeto projeto;
}
