package com.exemplo.meuapp.infrastructure.persistence.entity;

import com.exemplo.meuapp.domain.enums.UsuariosStatus;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "professores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfessoresEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36)
    private String id;

    @ManyToOne
    @JoinColumn(name = "usuarios_id", nullable = false)
    private UsuariosEntity usuarios;

    @Column(length = 100, nullable = false)
    private String especialidade;

    @Column(length = 100, nullable = false)
    private String departamento;

    @Column(length = 20)
    private String telefonePessoal;

    @Column(length = 20)
    private String telefoneProfissional;

    @Column(length = 255)
    private String linkedin;

    @ManyToOne
    @JoinColumn(name = "endereco_id")
    private EnderecoEntity endereco;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UsuariosStatus status;

    @Column(name = "criado_em", nullable = false)
    private LocalDateTime criadoEm;

    @Column(name = "atualizado_em")
    private LocalDateTime atualizadoEm;
}
