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

    public AnexoEtapa correct() {
        if (etapa == null) {
            throw new IllegalArgumentException("O campo etapa deve ser preenchido");
        }
        if (nomeArquivo == null || nomeArquivo.isBlank()) {
            throw new IllegalArgumentException("O campo nomeArquivo deve ser preenchido");
        }
        if (url == null || url.isBlank()) {
            throw new IllegalArgumentException("O campo url deve ser preenchido");
        }
        if (tipo == null) {
            throw new IllegalArgumentException("O campo tipo deve ser preenchido");
        }
        if (dataUpload == null) {
            throw new IllegalArgumentException("O campo dataUpload deve ser preenchido");
        }
        return this;
    }
}
