package com.exemplo.meuapp.application.port.in.anexoEtapa;

import com.exemplo.meuapp.application.port.out.AnexoEtapaGateways;
import com.exemplo.meuapp.domain.model.AnexoEtapa;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDateTime;
import java.util.UUID;

public class AtualizarAnexoEtapaUseCase {
    private AnexoEtapaGateways anexoEtapaGateways;

    public AtualizarAnexoEtapaUseCase(AnexoEtapaGateways anexoEtapaGateways) {
        this.anexoEtapaGateways = anexoEtapaGateways;
    }
    public AnexoEtapa atualizar(UUID uuid, AnexoEtapa anexoEtapa) {
        AnexoEtapa anexoEtapaInDb = anexoEtapaGateways.getAnexoEtapa(uuid);

        anexoEtapaInDb.setEtapa(anexoEtapa.getEtapa());
        anexoEtapaInDb.setNomeArquivo(anexoEtapa.getNomeArquivo());
        anexoEtapaInDb.setUrl(anexoEtapa.getUrl());
        anexoEtapaInDb.setTipo(anexoEtapa.getTipo());
        anexoEtapaInDb.setDataUpload(LocalDateTime.now());
        return anexoEtapaGateways.update(anexoEtapaInDb);
    }
}
