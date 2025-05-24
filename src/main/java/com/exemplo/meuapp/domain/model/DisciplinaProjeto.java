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
}
