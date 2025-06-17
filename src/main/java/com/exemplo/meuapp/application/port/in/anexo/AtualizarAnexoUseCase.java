package com.exemplo.meuapp.application.port.in.anexo;

    import com.exemplo.meuapp.application.port.out.AnexoGateways;
    import com.exemplo.meuapp.domain.exception.DadosInvalidosException;
    import com.exemplo.meuapp.domain.exception.RegraDeNegocioException;
    import com.exemplo.meuapp.domain.model.Anexo;

    import java.time.LocalDateTime;
    import java.util.UUID;

    public class AtualizarAnexoUseCase {
        private final AnexoGateways anexoGateways;

        public AtualizarAnexoUseCase(AnexoGateways anexoGateways) {
            this.anexoGateways = anexoGateways;
        }

        public Anexo atualizar(UUID uuid, Anexo anexo) {
            Anexo anexoInDb = anexoGateways.getAnexoEtapa(uuid);
            if (anexoInDb == null) {
                throw new RegraDeNegocioException("Anexo não encontrado.");
            }


            if (!anexoInDb.getNomeArquivo().equals(anexo.getNomeArquivo()) &&
                    anexoGateways.existsByEtapaAndNomeArquivo(anexo.getEtapa().getUuid(), anexo.getNomeArquivo())) {
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

            return anexoGateways.update(anexoInDb);
        }
    }