package com.exemplo.meuapp.application.port.in.anexoEtapa;

    import com.exemplo.meuapp.application.port.out.AnexoEtapaGateways;
    import com.exemplo.meuapp.domain.exception.DadosInvalidosException;
    import com.exemplo.meuapp.domain.exception.RegraDeNegocioException;
    import com.exemplo.meuapp.domain.model.Anexo;

    import java.time.LocalDateTime;
    import java.util.UUID;

    public class AtualizarAnexoEtapaUseCase {
        private final AnexoEtapaGateways anexoEtapaGateways;

        public AtualizarAnexoEtapaUseCase(AnexoEtapaGateways anexoEtapaGateways) {
            this.anexoEtapaGateways = anexoEtapaGateways;
        }

        public Anexo atualizar(UUID uuid, Anexo anexo) {
            Anexo anexoInDb = anexoEtapaGateways.getAnexoEtapa(uuid);
            if (anexoInDb == null) {
                throw new RegraDeNegocioException("Anexo não encontrado.");
            }

            anexo.correct();

            if (!anexoInDb.getNomeArquivo().equals(anexo.getNomeArquivo()) &&
                    anexoEtapaGateways.existsByEtapaAndNomeArquivo(anexo.getEtapa().getUuid(), anexo.getNomeArquivo())) {
                throw new RegraDeNegocioException("Já existe um anexo com este nome para a etapa.");
            }

            if (anexo.getUrl() == null || !anexo.getUrl().startsWith("https://")) {
                throw new DadosInvalidosException("URL do anexo deve começar com https://");
            }

            if (anexo.getDataUpload() != null && anexo.getDataUpload().isAfter(LocalDateTime.now())) {
                throw new RegraDeNegocioException("Data de upload não pode ser futura.");
            }

            anexoInDb.setEtapa(anexo.getEtapa());
            anexoInDb.setNomeArquivo(anexo.getNomeArquivo());
            anexoInDb.setUrl(anexo.getUrl());
            anexoInDb.setTipo(anexo.getTipo());
            anexoInDb.setDataUpload(LocalDateTime.now());

            return anexoEtapaGateways.update(anexoInDb);
        }
    }