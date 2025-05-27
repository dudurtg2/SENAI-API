package com.exemplo.meuapp.presentation.dto;

import com.exemplo.meuapp.infrastructure.persistence.entity.UsuariosEntity;

public class TokensDTO {
    private final String accessToken;
    private final String refreshToken;
    private final UsuariosEntity usuariosEntity;

    public TokensDTO(String accessToken, String refreshToken, UsuariosEntity usuariosEntity) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.usuariosEntity = usuariosEntity;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public UsuariosEntity getUsuariosEntity() {
        return usuariosEntity;
    }
}
