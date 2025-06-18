package com.exemplo.meuapp.common.mapper;

import com.exemplo.meuapp.domain.model.Curso;
import com.exemplo.meuapp.infrastructure.persistence.entity.CursoEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-18T15:18:33-0300",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.42.0.v20250514-1000, environment: Java 21.0.7 (Eclipse Adoptium)"
)
@Component
public class CursoMapperImpl implements CursoMapper {

    @Override
    public CursoEntity toEntity(Curso curso) {
        if ( curso == null ) {
            return null;
        }

        CursoEntity.CursoEntityBuilder cursoEntity = CursoEntity.builder();

        cursoEntity.cargaHoraria( curso.getCargaHoraria() );
        cursoEntity.descricao( curso.getDescricao() );
        cursoEntity.nome( curso.getNome() );
        cursoEntity.uuid( curso.getUuid() );

        return cursoEntity.build();
    }

    @Override
    public Curso toDomain(CursoEntity cursoEntity) {
        if ( cursoEntity == null ) {
            return null;
        }

        Curso.CursoBuilder curso = Curso.builder();

        curso.cargaHoraria( cursoEntity.getCargaHoraria() );
        curso.descricao( cursoEntity.getDescricao() );
        curso.nome( cursoEntity.getNome() );
        curso.uuid( cursoEntity.getUuid() );

        return curso.build();
    }

    @Override
    public List<Curso> toDomain(List<CursoEntity> cursoEntityList) {
        if ( cursoEntityList == null ) {
            return null;
        }

        List<Curso> list = new ArrayList<Curso>( cursoEntityList.size() );
        for ( CursoEntity cursoEntity : cursoEntityList ) {
            list.add( toDomain( cursoEntity ) );
        }

        return list;
    }

    @Override
    public List<CursoEntity> toEntity(List<Curso> cursoList) {
        if ( cursoList == null ) {
            return null;
        }

        List<CursoEntity> list = new ArrayList<CursoEntity>( cursoList.size() );
        for ( Curso curso : cursoList ) {
            list.add( toEntity( curso ) );
        }

        return list;
    }
}
