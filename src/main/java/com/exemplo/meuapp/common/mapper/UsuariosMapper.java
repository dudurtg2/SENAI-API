package com.exemplo.meuapp.common.mapper;

import java.util.List;

import com.exemplo.meuapp.domain.model.Usuarios;

import org.mapstruct.Mapper;

import com.exemplo.meuapp.infrastructure.persistence.entity.UsuariosEntity;

@Mapper(componentModel = "spring")
public interface UsuariosMapper {

    UsuariosEntity toEntity(Usuarios usuarios);

    Usuarios toDomain(UsuariosEntity usuariosEntity);

    List<Usuarios> toDomain(List<UsuariosEntity> usuariosEntities);

    List<UsuariosEntity> toEntity(List<Usuarios> usuarios);
}
