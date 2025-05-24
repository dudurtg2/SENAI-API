package com.exemplo.meuapp.domain.model;
import java.util.UUID;

import com.exemplo.meuapp.domain.enums.TipoAnexo;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class AnexoEtapa {
    private UUID uuid;
    private EtapasProjeto etapa;
    private String nomeArquivo;
    private String url;
    private TipoAnexo tipo;
    private LocalDateTime dataUpload;
}
