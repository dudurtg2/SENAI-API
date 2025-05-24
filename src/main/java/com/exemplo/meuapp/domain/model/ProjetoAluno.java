package com.exemplo.meuapp.domain.model;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class ProjetoAluno {
    private String id;
    private Projeto projeto;
    private Alunos aluno;
}
