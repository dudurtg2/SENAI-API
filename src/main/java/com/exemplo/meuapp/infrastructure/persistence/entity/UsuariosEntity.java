package com.exemplo.meuapp.infrastructure.persistence.entity;

import com.exemplo.meuapp.domain.enums.UsuariosStatus;
import com.exemplo.meuapp.domain.enums.UsuarioTipo;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

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
    @Column(length = 36)
    private String id;

    @Column(length = 50, nullable = false)
    private String usuario;

    @Column(length = 255, nullable = false)
    private String senha;

    @Column(length = 100, nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private UsuarioTipo tipo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private UsuariosStatus status;

    @Column(name = "criado_em", nullable = false)
    private LocalDateTime criadoEm;

    @Column(name = "atualizado_em")
    private LocalDateTime atualizadoEm;
}
