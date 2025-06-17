package com.exemplo.meuapp.application.port.in.anexoEtapa;

    import com.exemplo.meuapp.application.port.out.AnexoEtapaGateways;
    import com.exemplo.meuapp.domain.exception.DadosInvalidosException;
    import com.exemplo.meuapp.domain.exception.RegraDeNegocioException;
    import com.exemplo.meuapp.domain.model.Anexo;

    import java.time.LocalDateTime;

    public class CriarAnexoEtapaUseCase {
        private AnexoEtapaGateways anexoEtapaGateways;

        public CriarAnexoEtapaUseCase(AnexoEtapaGateways anexoEtapaGateways) {
            this.anexoEtapaGateways = anexoEtapaGateways;
        }

        public Anexo criar(Anexo anexo) {
            anexo.setDataUpload(LocalDateTime.now());
            anexo.correct();


            if (!anexo.getNomeArquivo().matches("^[\\w\\-. ]+$")) {
                throw new DadosInvalidosException("Nome do arquivo contém caracteres inválidos.");
            }


            if (!anexo.getUrl().startsWith("https://")) {
                throw new DadosInvalidosException("A URL do anexo deve começar com https://");
            }

            if (anexoEtapaGateways.existsByEtapaAndNomeArquivo(
                    anexo.getEtapa().getUuid(), anexo.getNomeArquivo())) {
                throw new RegraDeNegocioException("Já existe um anexo com este nome para esta etapa.");
            }

            if (anexo.getDataUpload() != null && anexo.getDataUpload().isAfter(LocalDateTime.now())) {
                throw new RegraDeNegocioException("Data de upload não pode ser futura.");
            }

            return anexoEtapaGateways.save(anexo);
        }
    }