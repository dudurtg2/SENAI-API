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
}
