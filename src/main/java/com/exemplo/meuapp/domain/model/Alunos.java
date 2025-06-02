package com.exemplo.meuapp.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;

import com.exemplo.meuapp.domain.enums.UsuariosStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class Alunos {

    private UUID uuid;
    private Usuarios usuarios;

    private String matricula;
    private String curso;
    
    private String telefonePessoal;
    private String telefoneProfissional;
    private String linkedin;
    private Endereco endereco;
    private UsuariosStatus status;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;

    public Alunos correct() {
        if (usuarios == null) {
            throw new IllegalArgumentException("Usuário não pode ser nulo");
        }
        if (matricula == null || matricula.isBlank()) {
            throw new IllegalArgumentException("Matrícula não pode ser nula ou vazia");
        }
        if (curso == null || curso.isBlank()) {
            throw new IllegalArgumentException("Curso não pode ser nulo ou vazio");
        }
        if (telefoneProfissional == null || telefoneProfissional.isBlank()) {
            throw new IllegalArgumentException("Telefone profissional não pode ser nulo ou vazio");
        }
        if (endereco == null) {
            throw new IllegalArgumentException("Endereço não pode ser nulo");
        }
        if (status == null) {
            throw new IllegalArgumentException("Status não pode ser nulo");
        }
        return this;
    }

}
