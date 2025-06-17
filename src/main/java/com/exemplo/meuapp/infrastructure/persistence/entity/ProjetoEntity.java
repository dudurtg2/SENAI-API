package com.exemplo.meuapp.infrastructure.persistence.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.exemplo.meuapp.domain.enums.ProjetoStatus;
import com.exemplo.meuapp.domain.enums.Visibilidade;
import com.exemplo.meuapp.domain.model.Disciplina;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "projeto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjetoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "uuid")
    private UUID uuid;

    @Column(length = 100)
    private String titulo;

    @Column(length = 1000)
    private String descricao;

    @Column(length = 20)
    private String turma;

    @Column(nullable = false)
    private boolean labMaker;

    @Column(nullable = false)
    private boolean participouSaga;

    @Column(nullable = false)
    private boolean itinerario;

    @ManyToOne
    @JoinColumn(name = "disciplina_uuid")
    private DisciplinaEntity disciplina;

    @ManyToMany
    @JoinTable(
            name = "projeto_anexos",
            joinColumns = @JoinColumn(name = "projeto_uuid"),
            inverseJoinColumns = @JoinColumn(name = "anexos_uuid")
    )
    private List<AnexoEntity> anexos;

    @ManyToOne
    @JoinColumn(name = "lider_uuid")
    private AlunosEntity lider;

    @Column(length = 255)
    private String bannerUrl;

    @Column(length = 20)
    private String codigo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Visibilidade visibilidade;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private ProjetoStatus status;

    @Column(name = "criado_em")
    private LocalDateTime criadoEm;

    @Column(name = "atualizado_em")
    private LocalDateTime atualizadoEm;
}
