package com.exemplo.meuapp.common.mapper;

import java.util.List;

import com.exemplo.meuapp.domain.model.Professores;

import org.mapstruct.Mapper;

import com.exemplo.meuapp.infrastructure.persistence.entity.ProfessoresEntity;

@Mapper(componentModel = "spring")
public interface ProfessoresMapper {

    ProfessoresEntity toEntity(Professores professores);

    Professores toDomain(ProfessoresEntity professoresEntity);

    List<Professores> toDomain(List<ProfessoresEntity> professoresEntityList);

    List<ProfessoresEntity> toEntity(List<Professores> professoresList);
}
