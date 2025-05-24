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
}
