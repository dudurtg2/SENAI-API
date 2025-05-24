package com.exemplo.meuapp.common.mapper;

import com.exemplo.meuapp.domain.model.UnidadeCurricular;
import com.exemplo.meuapp.infrastructure.persistence.entity.UnidadeCurricularEntity;
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
public class UnidadeCurricularMapperImpl implements UnidadeCurricularMapper {

    @Override
    public UnidadeCurricularEntity toEntity(UnidadeCurricular aluno) {
        if ( aluno == null ) {
            return null;
        }

        UnidadeCurricularEntity unidadeCurricularEntity = new UnidadeCurricularEntity();

        return unidadeCurricularEntity;
    }

    @Override
    public UnidadeCurricular toDomain(UnidadeCurricularEntity alunoEntity) {
        if ( alunoEntity == null ) {
            return null;
        }

        UnidadeCurricular unidadeCurricular = new UnidadeCurricular();

        return unidadeCurricular;
    }

    @Override
    public List<UnidadeCurricular> toDomain(List<UnidadeCurricularEntity> UnidadeCurricularEntities) {
        if ( UnidadeCurricularEntities == null ) {
            return null;
        }

        List<UnidadeCurricular> list = new ArrayList<UnidadeCurricular>( UnidadeCurricularEntities.size() );
        for ( UnidadeCurricularEntity unidadeCurricularEntity : UnidadeCurricularEntities ) {
            list.add( toDomain( unidadeCurricularEntity ) );
        }

        return list;
    }

    @Override
    public List<UnidadeCurricularEntity> toEntity(List<UnidadeCurricular> UnidadeCurricular) {
        if ( UnidadeCurricular == null ) {
            return null;
        }

        List<UnidadeCurricularEntity> list = new ArrayList<UnidadeCurricularEntity>( UnidadeCurricular.size() );
        for ( UnidadeCurricular unidadeCurricular : UnidadeCurricular ) {
            list.add( toEntity( unidadeCurricular ) );
        }

        return list;
    }
}
