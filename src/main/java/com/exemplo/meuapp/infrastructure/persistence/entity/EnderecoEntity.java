package com.exemplo.meuapp.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "endereco")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EnderecoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36)
    private String id;

    @Column(length = 20, nullable = false)
    private String cep;

    @Column(length = 100, nullable = false)
    private String logradouro;

    @Column(nullable = false)
    private int numero;

    @Column(length = 100)
    private String complemento;

    @Column(length = 50, nullable = false)
    private String bairro;

    @Column(length = 50, nullable = false)
    private String cidade;

    @Column(length = 2, nullable = false)
    private String estado;

    @Column(length = 50, nullable = false)
    private String pais;
}