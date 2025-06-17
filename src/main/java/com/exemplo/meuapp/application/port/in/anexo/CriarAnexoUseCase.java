package com.exemplo.meuapp.application.port.in.anexo;

    import com.exemplo.meuapp.application.port.out.AnexoGateways;
    import com.exemplo.meuapp.domain.exception.DadosInvalidosException;
    import com.exemplo.meuapp.domain.exception.RegraDeNegocioException;
    import com.exemplo.meuapp.domain.model.Anexo;

    import java.time.LocalDateTime;

    public class CriarAnexoUseCase {
        private AnexoGateways anexoGateways;

        public CriarAnexoUseCase(AnexoGateways anexoGateways) {
            this.anexoGateways = anexoGateways;
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

            if (anexoGateways.existsByEtapaAndNomeArquivo(
                    anexo.getEtapa().getUuid(), anexo.getNomeArquivo())) {
                throw new RegraDeNegocioException("Já existe um anexo com este nome para esta etapa.");
            }

            if (anexo.getDataUpload() != null && anexo.getDataUpload().isAfter(LocalDateTime.now())) {
                throw new RegraDeNegocioException("Data de upload não pode ser futura.");
            }

            return anexoGateways.save(anexo);
        }
    }