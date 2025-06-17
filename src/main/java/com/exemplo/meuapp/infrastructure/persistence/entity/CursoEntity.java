package com.exemplo.meuapp.infrastructure.persistence.entity;

import java.util.UUID;

import com.exemplo.meuapp.domain.exception.DadosInvalidosException;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Table(name = "cursos")
@Entity
public class CursoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "uuid")
    private UUID uuid;

    @Column(name="nome")
    private String nome;

    @Column(name="descricao")
    private String descricao;

    @Column(name="carga_horaria")
    private String cargaHoraria;

    public CursoEntity correct() {
        if (nome == null || nome.isBlank()) {
            throw new DadosInvalidosException("Nome nao pode ser nulo ou vazio");
        }
        if(descricao == null || descricao.isBlank()) {
            throw new DadosInvalidosException("Descricao nao pode ser nula ou vazia");
        }
        if(cargaHoraria == null || cargaHoraria.isBlank()) {
            throw new DadosInvalidosException("Carga horaria nao pode ser nula ou vazia");
        }
        return this;
    }

}
