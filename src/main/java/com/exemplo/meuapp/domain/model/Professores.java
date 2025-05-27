package com.exemplo.meuapp.domain.model;

import com.exemplo.meuapp.domain.enums.UsuariosStatus;
import lombok.*;
import java.util.UUID;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class Professores {

    private UUID uuid;
    private Usuarios usuariosId;
    private String especialidade;
    private String departamento;
    private String telefonePessoal;
    private String telefoneProfissional;
    private String linkedin;
    private Endereco endereco;
    private UsuariosStatus status;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;

    public Professores correct() {
        if (usuariosId == null) {
            throw new IllegalArgumentException("Usuário não pode ser nulo");
        }
        if (especialidade == null || especialidade.isBlank()) {
            throw new IllegalArgumentException("Especialidade não pode ser nula ou vazia");
        }
        if (departamento == null || departamento.isBlank()) {
            throw new IllegalArgumentException("Departamento não pode ser nulo ou vazio");
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
