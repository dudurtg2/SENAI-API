package com.exemplo.meuapp.common.mapper;

import java.util.List;

import com.exemplo.meuapp.domain.model.Anexo;

import org.mapstruct.Mapper;

import com.exemplo.meuapp.infrastructure.persistence.entity.AnexoEntity;

@Mapper(componentModel = "spring")
public interface AnexoEtapaMapper {

    AnexoEntity toEntity(Anexo aluno);

    Anexo toDomain(AnexoEntity alunoEntity);

    List<Anexo> toDomain(List<AnexoEntity> AnexoEtapaEntities);

    List<AnexoEntity> toEntity(List<Anexo> Anexo);
}
