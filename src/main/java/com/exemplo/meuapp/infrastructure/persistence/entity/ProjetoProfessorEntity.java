package com.exemplo.meuapp.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "projeto_professor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjetoProfessorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36)
    private String id;

    @ManyToOne
    @JoinColumn(name = "projeto_id", nullable = false)
    private ProjetoEntity projeto;

    @ManyToOne
    @JoinColumn(name = "professor_id", nullable = false)
    private ProfessoresEntity professor;

    @Column(name = "is_orientador", nullable = false)
    private Boolean isOrientador;
}