package com.exemplo.meuapp.infrastructure.persistence.entity;

import com.exemplo.meuapp.domain.enums.ProjetoStatus;
import com.exemplo.meuapp.domain.enums.Visibilidade;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

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
    @Column(length = 36)
    private String id;

    @Column(length = 100, nullable = false)
    private String titulo;

    @Column(length = 1000)
    private String descricao;

    @Column(length = 100)
    private String curso;

    @Column(length = 20)
    private String turma;

    @Column(nullable = false)
    private boolean labMaker;

    @Column(nullable = false)
    private boolean participouSaga;

    @Column(nullable = false)
    private boolean itinerario;

    @ManyToOne
    @JoinColumn(name = "unidade_curricular_id")
    private UnidadeCurricularEntity unidadeCurricular;

    @ManyToOne
    @JoinColumn(name = "lider_projeto_id")
    private AlunosEntity liderProjeto;

    @Column(length = 255)
    private String bannerUrl;

    @Column(length = 20)
    private String codigo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Visibilidade visibilidadeCodigo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Visibilidade visibilidadeAnexos;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private ProjetoStatus status;

    @Column(name = "criado_em", nullable = false)
    private LocalDateTime criadoEm;

    @Column(name = "atualizado_em")
    private LocalDateTime atualizadoEm;
}
