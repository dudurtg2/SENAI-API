package com.exemplo.meuapp.common.mapper;

import com.exemplo.meuapp.domain.model.EtapasProjeto;
import com.exemplo.meuapp.infrastructure.persistence.entity.EtapasProjetoEntity;
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
public class EtapasProjetoMapperImpl implements EtapasProjetoMapper {

    @Override
    public EtapasProjetoEntity toEntity(EtapasProjeto aluno) {
        if ( aluno == null ) {
            return null;
        }

        EtapasProjetoEntity etapasProjetoEntity = new EtapasProjetoEntity();

        return etapasProjetoEntity;
    }

    @Override
    public EtapasProjeto toDomain(EtapasProjetoEntity alunoEntity) {
        if ( alunoEntity == null ) {
            return null;
        }

        EtapasProjeto etapasProjeto = new EtapasProjeto();

        return etapasProjeto;
    }

    @Override
    public List<EtapasProjeto> toDomain(List<EtapasProjetoEntity> EtapasProjetoEntities) {
        if ( EtapasProjetoEntities == null ) {
            return null;
        }

        List<EtapasProjeto> list = new ArrayList<EtapasProjeto>( EtapasProjetoEntities.size() );
        for ( EtapasProjetoEntity etapasProjetoEntity : EtapasProjetoEntities ) {
            list.add( toDomain( etapasProjetoEntity ) );
        }

        return list;
    }

    @Override
    public List<EtapasProjetoEntity> toEntity(List<EtapasProjeto> EtapasProjeto) {
        if ( EtapasProjeto == null ) {
            return null;
        }

        List<EtapasProjetoEntity> list = new ArrayList<EtapasProjetoEntity>( EtapasProjeto.size() );
        for ( EtapasProjeto etapasProjeto : EtapasProjeto ) {
            list.add( toEntity( etapasProjeto ) );
        }

        return list;
    }
}
