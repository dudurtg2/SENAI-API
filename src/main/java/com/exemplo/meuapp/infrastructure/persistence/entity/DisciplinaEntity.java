package com.exemplo.meuapp.infrastructure.persistence.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.exemplo.meuapp.domain.model.Anexo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "disciplina")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DisciplinaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "uuid")
    private UUID uuid;

    @Column(length = 100)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "professor_uuid")
    private ProfessoresEntity professor;



    @Column(name = "criado_em")
    private LocalDateTime criadoEm;

    @Column(name = "atualizado_em")
    private LocalDateTime atualizadoEm;

    @Column(name="descricao")
    private String descricao;

    @Column(name="carga_horaria")
    private String cargaHoraria;
}
