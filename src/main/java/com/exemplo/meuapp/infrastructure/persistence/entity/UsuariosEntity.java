package com.exemplo.meuapp.infrastructure.persistence.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import com.exemplo.meuapp.domain.enums.UsuarioTipo;
import com.exemplo.meuapp.domain.enums.UsuariosStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuariosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "uuid")
    private UUID uuid;

    @Column(length = 50)
    private String usuario;

    @Column(length = 255)
    private String senha;

    @Column(length = 100)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private UsuarioTipo tipo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private UsuariosStatus status;

    @Column(name = "criado_em")
    private LocalDateTime criadoEm;

    @Column(name = "atualizado_em")
    private LocalDateTime atualizadoEm;
}

