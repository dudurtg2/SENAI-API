package com.exemplo.meuapp.domain.model;

import com.exemplo.meuapp.domain.enums.UsuariosStatus;
import com.exemplo.meuapp.domain.enums.UsuarioTipo;
import lombok.*;
import java.util.UUID;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class Usuarios {

    private UUID uuid;
    private String usuario;
    private String senha;
    private String email;
    private UsuarioTipo tipo;
    private UsuariosStatus status;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;

}
