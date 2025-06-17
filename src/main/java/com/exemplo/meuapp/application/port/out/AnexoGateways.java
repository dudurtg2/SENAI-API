package com.exemplo.meuapp.application.port.out;

import com.exemplo.meuapp.domain.model.Anexo;

import java.util.List;
import java.util.UUID;

public interface AnexoGateways {
    Anexo save(Anexo anexo);

    Anexo getAnexoEtapa(UUID anexoEtapaId);

    void delete(UUID anexoEtapaId);

    Anexo update(Anexo anexo);

    List<Anexo> getAllAnexosEtapa();

    List<Anexo> getAnexosByEtapaId(UUID etapaId);

    List<Anexo> getAnexosByEtapaIdAndTipo(UUID etapaId, String tipo);

    boolean existsByEtapaAndNomeArquivo(UUID uuid, String nomeArquivo);
}
