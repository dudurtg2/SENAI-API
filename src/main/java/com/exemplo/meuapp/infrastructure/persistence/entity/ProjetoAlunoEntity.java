package com.exemplo.meuapp.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "projeto_aluno")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjetoAlunoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36)
    private String id;

    @ManyToOne
    @JoinColumn(name = "projeto_id", nullable = false)
    private ProjetoEntity projeto;

    @ManyToOne
    @JoinColumn(name = "aluno_id", nullable = false)
    private AlunosEntity aluno;
}
