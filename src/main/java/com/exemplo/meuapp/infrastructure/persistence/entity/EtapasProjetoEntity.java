package com.exemplo.meuapp.infrastructure.persistence.entity;

import com.exemplo.meuapp.domain.enums.EtapaStatus;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "etapas_projeto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EtapasProjetoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36)
    private String id;

    @ManyToOne
    @JoinColumn(name = "projeto_id", nullable = false)
    private ProjetoEntity projeto;

    @Column(length = 100, nullable = false)
    private String nomeEtapa;

    @Column(length = 1000)
    private String descricao;

    @Column(nullable = false)
    private int ordem;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private EtapaStatus status;

    @Column(name = "criado_em", nullable = false)
    private LocalDateTime criadoEm;

    @Column(name = "atualizado_em")
    private LocalDateTime atualizadoEm;
}
