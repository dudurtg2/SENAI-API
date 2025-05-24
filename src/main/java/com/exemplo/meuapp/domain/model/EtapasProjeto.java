package com.exemplo.meuapp.domain.model;

import com.exemplo.meuapp.domain.enums.EtapaStatus;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class EtapasProjeto {
    private String id;
    private Projeto projeto;
    private String nomeEtapa;
    private String descricao;
    private int ordem;
    private EtapaStatus status;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;
}