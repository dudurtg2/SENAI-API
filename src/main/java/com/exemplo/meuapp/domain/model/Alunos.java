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
    private Usuarios usariosId;
    private String matricula;
    private String curso;
    private String telefonePessoal;
    private String telefoneProfissional;
    private String linkedin;
    private Endereco endereco;
    private UsuariosStatus status;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;

}
