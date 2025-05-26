package com.exemplo.meuapp.common.mapper;

import com.exemplo.meuapp.domain.model.Alunos;
import com.exemplo.meuapp.infrastructure.persistence.entity.AlunosEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-25T16:09:46-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 21.0.5 (JetBrains s.r.o.)"
)
@Component
public class AlunosMapperImpl implements AlunosMapper {

    @Override
    public AlunosEntity toEntity(Alunos alunos) {
        if ( alunos == null ) {
            return null;
        }

        AlunosEntity alunosEntity = new AlunosEntity();

        return alunosEntity;
    }

    @Override
    public Alunos toDomain(AlunosEntity alunosEntity) {
        if ( alunosEntity == null ) {
            return null;
        }

        Alunos alunos = new Alunos();

        return alunos;
    }

    @Override
    public List<Alunos> toDomain(List<AlunosEntity> alunosEntities) {
        if ( alunosEntities == null ) {
            return null;
        }

        List<Alunos> list = new ArrayList<Alunos>( alunosEntities.size() );
        for ( AlunosEntity alunosEntity : alunosEntities ) {
            list.add( toDomain( alunosEntity ) );
        }

        return list;
    }

    @Override
    public List<AlunosEntity> toEntity(List<Alunos> alunos) {
        if ( alunos == null ) {
            return null;
        }

        List<AlunosEntity> list = new ArrayList<AlunosEntity>( alunos.size() );
        for ( Alunos alunos1 : alunos ) {
            list.add( toEntity( alunos1 ) );
        }

        return list;
    }
}
