package com.exemplo.meuapp.common.mapper;

import com.exemplo.meuapp.domain.model.UnidadeCurricular;
import com.exemplo.meuapp.infrastructure.persistence.entity.UnidadeCurricularEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-27T00:56:33-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 22.0.2 (Oracle Corporation)"
)
@Component
public class UnidadeCurricularMapperImpl implements UnidadeCurricularMapper {

    @Override
    public UnidadeCurricularEntity toEntity(UnidadeCurricular aluno) {
        if ( aluno == null ) {
            return null;
        }

        UnidadeCurricularEntity.UnidadeCurricularEntityBuilder unidadeCurricularEntity = UnidadeCurricularEntity.builder();

        unidadeCurricularEntity.uuid( aluno.getUuid() );
        unidadeCurricularEntity.nome( aluno.getNome() );
        unidadeCurricularEntity.descricao( aluno.getDescricao() );
        unidadeCurricularEntity.cargaHoraria( aluno.getCargaHoraria() );
        unidadeCurricularEntity.criadoEm( aluno.getCriadoEm() );
        unidadeCurricularEntity.atualizadoEm( aluno.getAtualizadoEm() );

        return unidadeCurricularEntity.build();
    }

    @Override
    public UnidadeCurricular toDomain(UnidadeCurricularEntity alunoEntity) {
        if ( alunoEntity == null ) {
            return null;
        }

        UnidadeCurricular.UnidadeCurricularBuilder unidadeCurricular = UnidadeCurricular.builder();

        unidadeCurricular.uuid( alunoEntity.getUuid() );
        unidadeCurricular.nome( alunoEntity.getNome() );
        unidadeCurricular.descricao( alunoEntity.getDescricao() );
        unidadeCurricular.cargaHoraria( alunoEntity.getCargaHoraria() );
        unidadeCurricular.criadoEm( alunoEntity.getCriadoEm() );
        unidadeCurricular.atualizadoEm( alunoEntity.getAtualizadoEm() );

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
