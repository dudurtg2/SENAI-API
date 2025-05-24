package com.exemplo.meuapp.common.mapper;

import com.exemplo.meuapp.domain.model.AnexoEtapa;
import com.exemplo.meuapp.infrastructure.persistence.entity.AnexoEtapaEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-24T18:32:28-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 21.0.5 (JetBrains s.r.o.)"
)
@Component
public class AnexoEtapaMapperImpl implements AnexoEtapaMapper {

    @Override
    public AnexoEtapaEntity toEntity(AnexoEtapa aluno) {
        if ( aluno == null ) {
            return null;
        }

        AnexoEtapaEntity anexoEtapaEntity = new AnexoEtapaEntity();

        return anexoEtapaEntity;
    }

    @Override
    public AnexoEtapa toDomain(AnexoEtapaEntity alunoEntity) {
        if ( alunoEntity == null ) {
            return null;
        }

        AnexoEtapa anexoEtapa = new AnexoEtapa();

        return anexoEtapa;
    }

    @Override
    public List<AnexoEtapa> toDomain(List<AnexoEtapaEntity> AnexoEtapaEntities) {
        if ( AnexoEtapaEntities == null ) {
            return null;
        }

        List<AnexoEtapa> list = new ArrayList<AnexoEtapa>( AnexoEtapaEntities.size() );
        for ( AnexoEtapaEntity anexoEtapaEntity : AnexoEtapaEntities ) {
            list.add( toDomain( anexoEtapaEntity ) );
        }

        return list;
    }

    @Override
    public List<AnexoEtapaEntity> toEntity(List<AnexoEtapa> AnexoEtapa) {
        if ( AnexoEtapa == null ) {
            return null;
        }

        List<AnexoEtapaEntity> list = new ArrayList<AnexoEtapaEntity>( AnexoEtapa.size() );
        for ( AnexoEtapa anexoEtapa : AnexoEtapa ) {
            list.add( toEntity( anexoEtapa ) );
        }

        return list;
    }
}
