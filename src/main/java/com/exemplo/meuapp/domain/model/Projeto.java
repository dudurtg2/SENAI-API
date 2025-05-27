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

    public Projeto correct() {
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("Título não pode ser nulo ou vazio");
        }
        if (descricao == null || descricao.isBlank()) {
            throw new IllegalArgumentException("Descrição não pode ser nula ou vazia");
        }
        if (curso == null || curso.isBlank()) {
            throw new IllegalArgumentException("Curso não pode ser nulo ou vazio");
        }
        if (turma == null || turma.isBlank()) {
            throw new IllegalArgumentException("Turma não pode ser nula ou vazia");
        }
        if (unidadeCurricular == null) {
            throw new IllegalArgumentException("Unidade Curricular não pode ser nula");
        }
        if (liderProjeto == null) {
            throw new IllegalArgumentException("Líder do projeto não pode ser nulo");
        }
        if (status == null) {
            throw new IllegalArgumentException("Status não pode ser nulo");
        }
        return this;
    }
}
