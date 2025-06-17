package com.exemplo.meuapp.domain.model;

import com.exemplo.meuapp.domain.exception.DadosInvalidosException;
import lombok.*;
import java.util.UUID;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class Disciplina {

    private UUID uuid;
    private String nome;
    private Professores professor;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;
    private String descricao;
    private String cargaHoraria;
    private Curso curso;



    public Disciplina correct() {
        if (nome == null || nome.isBlank()) {
            throw new DadosInvalidosException("Nome não pode ser nulo ou vazio");
        }
        if (professor == null) {
            throw new DadosInvalidosException("Professor não pode ser nulo");
        }
        if (descricao == null || descricao.isBlank()) {
            throw new DadosInvalidosException("Descrição nao pode ser nula ou vazia");
        }
        if (cargaHoraria == null || cargaHoraria.isBlank()) {
            throw new DadosInvalidosException("Carga horaria nao pode ser nula ou vazia");
        }
        if (curso == null) {
            throw new DadosInvalidosException("Curso nao pode ser nulo");
        }
        
        return this;
    }
}
