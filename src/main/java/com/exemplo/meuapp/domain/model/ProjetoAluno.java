package com.exemplo.meuapp.domain.model;

import lombok.*;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class ProjetoAluno {

    private UUID uuid;
    private Projeto projeto;
    private Alunos aluno;
}
