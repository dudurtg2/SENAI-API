package com.exemplo.meuapp.common.mapper;

import java.util.List;

import com.exemplo.meuapp.domain.model.Curso;

import org.mapstruct.Mapper;

import com.exemplo.meuapp.infrastructure.persistence.entity.CursoEntity;

@Mapper(componentModel = "spring")
public interface CursoMapper {

    CursoEntity toEntity(Curso curso);

    Curso toDomain(CursoEntity cursoEntity);

    List<Curso> toDomain(List<CursoEntity> cursoEntityList);

    List<CursoEntity> toEntity(List<Curso> cursoList);
}
