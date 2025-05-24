package com.exemplo.meuapp.domain.model;

import com.exemplo.meuapp.domain.enums.ProjetoStatus;
import com.exemplo.meuapp.domain.enums.Visibilidade;
import lombok.*;
import java.util.UUID;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class Projeto {

    private UUID uuid;
    private String titulo;
    private String descricao;
    private String curso;
    private String turma;
    private boolean labMaker;
    private boolean participouSaga;
    private boolean itinerario;
    private UnidadeCurricular unidadeCurricular;
    private Alunos liderProjeto;
    private String bannerUrl;
    private String codigo;
    private Visibilidade visibilidadeCodigo;
    private Visibilidade visibilidadeAnexos;
    private ProjetoStatus status;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;
}
