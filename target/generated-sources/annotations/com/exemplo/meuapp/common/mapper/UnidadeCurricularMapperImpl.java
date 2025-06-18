package com.exemplo.meuapp.common.mapper;

import com.exemplo.meuapp.domain.model.UnidadeCurricular;
import com.exemplo.meuapp.infrastructure.persistence.entity.UnidadeCurricularEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-18T13:44:09-0300",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.42.0.v20250514-1000, environment: Java 21.0.7 (Eclipse Adoptium)"
)
@Component
public class UnidadeCurricularMapperImpl implements UnidadeCurricularMapper {

    @Override
    public UnidadeCurricularEntity toEntity(UnidadeCurricular aluno) {
        if ( aluno == null ) {
            return null;
        }

        UnidadeCurricularEntity.UnidadeCurricularEntityBuilder unidadeCurricularEntity = UnidadeCurricularEntity.builder();

        unidadeCurricularEntity.atualizadoEm( aluno.getAtualizadoEm() );
        unidadeCurricularEntity.cargaHoraria( aluno.getCargaHoraria() );
        unidadeCurricularEntity.criadoEm( aluno.getCriadoEm() );
        unidadeCurricularEntity.descricao( aluno.getDescricao() );
        unidadeCurricularEntity.nome( aluno.getNome() );
        unidadeCurricularEntity.uuid( aluno.getUuid() );

        return unidadeCurricularEntity.build();
    }

    @Override
    public UnidadeCurricular toDomain(UnidadeCurricularEntity alunoEntity) {
        if ( alunoEntity == null ) {
            return null;
        }

        UnidadeCurricular.UnidadeCurricularBuilder unidadeCurricular = UnidadeCurricular.builder();

        unidadeCurricular.atualizadoEm( alunoEntity.getAtualizadoEm() );
        unidadeCurricular.cargaHoraria( alunoEntity.getCargaHoraria() );
        unidadeCurricular.criadoEm( alunoEntity.getCriadoEm() );
        unidadeCurricular.descricao( alunoEntity.getDescricao() );
        unidadeCurricular.nome( alunoEntity.getNome() );
        unidadeCurricular.uuid( alunoEntity.getUuid() );

        return unidadeCurricular.build();
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
