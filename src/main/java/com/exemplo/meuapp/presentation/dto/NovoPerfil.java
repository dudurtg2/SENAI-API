package com.exemplo.meuapp.presentation.dto;

import com.exemplo.meuapp.domain.enums.UsuarioTipo;
import com.exemplo.meuapp.domain.enums.UsuariosStatus;

import java.time.LocalDateTime;

public record NovoPerfil(
        String usuario,
        String senha,
        String email,
        UsuariosStatus status
) {}

