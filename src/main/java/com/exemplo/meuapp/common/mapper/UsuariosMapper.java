package com.exemplo.meuapp.common.mapper;

import java.util.List;

import com.exemplo.meuapp.domain.model.Usuarios;

import org.mapstruct.Mapper;

import com.exemplo.meuapp.infrastructure.persistence.entity.UsuariosEntity;

@Mapper(componentModel = "spring")
public interface UsuariosMapper {

    UsuariosEntity toEntity(Usuarios aluno);

    Usuarios toDomain(UsuariosEntity alunoEntity);

    List<Usuarios> toDomain(List<UsuariosEntity> UsuariosEntities);

    List<UsuariosEntity> toEntity(List<Usuarios> Usuarios);
}
