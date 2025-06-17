package com.exemplo.meuapp.domain.model;

import com.exemplo.meuapp.domain.enums.ProjetoStatus;
import com.exemplo.meuapp.domain.enums.Visibilidade;
import com.exemplo.meuapp.domain.exception.DadosInvalidosException;
import lombok.*;

import java.util.List;
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
    private String turma;
    private String bannerUrl;
    private String codigo;

    private List<Anexo> anexos;
    private Disciplina disciplina;
    private Alunos lider;

    private boolean labMaker;
    private boolean participouSaga;
    private boolean itinerario;

    private Visibilidade visibilidade;
    private ProjetoStatus status;

    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;

    public Projeto correct() {
        if (this.titulo == null || titulo.isBlank()) {
            throw new DadosInvalidosException("Título não pode ser nulo ou vazio");
        }
        if (this.descricao == null || descricao.isBlank()) {
            throw new DadosInvalidosException("Descrição não pode ser nula ou vazia");
        }
        if (this.turma == null || turma.isBlank()) {
            throw new DadosInvalidosException("Turma não pode ser nula ou vazia");
        }
        if (this.disciplina == null) {
            throw new DadosInvalidosException("Unidade Curricular não pode ser nula");
        }
        if (this.lider == null) {
            throw new DadosInvalidosException("Líder do projeto não pode ser nulo");
        }
        if (this.status == null) {
            throw new DadosInvalidosException("Status não pode ser nulo");
        }
        if (this.visibilidade == null) {
            throw new DadosInvalidosException("Visibilidade não pode ser nulo");
        }
        return this;
    }
}
