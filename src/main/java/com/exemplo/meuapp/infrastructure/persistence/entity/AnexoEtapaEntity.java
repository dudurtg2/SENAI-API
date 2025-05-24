package com.exemplo.meuapp.infrastructure.persistence.entity;

import com.exemplo.meuapp.domain.enums.TipoAnexo;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "anexo_etapa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnexoEtapaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36)
    private String id;

    @ManyToOne
    @JoinColumn(name = "etapa_id", nullable = false)
    private EtapasProjetoEntity etapa;

    @Column(length = 255, nullable = false)
    private String nomeArquivo;

    @Column(length = 500, nullable = false)
    private String url;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private TipoAnexo tipo;

    @Column(name = "data_upload", nullable = false)
    private LocalDateTime dataUpload;
}
