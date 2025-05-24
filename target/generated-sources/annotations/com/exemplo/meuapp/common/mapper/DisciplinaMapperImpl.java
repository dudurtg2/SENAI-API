package com.exemplo.meuapp.common.mapper;

import com.exemplo.meuapp.domain.model.Disciplina;
import com.exemplo.meuapp.infrastructure.persistence.entity.DisciplinaEntity;
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
public class DisciplinaMapperImpl implements DisciplinaMapper {

    @Override
    public DisciplinaEntity toEntity(Disciplina aluno) {
        if ( aluno == null ) {
            return null;
        }

        DisciplinaEntity disciplinaEntity = new DisciplinaEntity();

        return disciplinaEntity;
    }

    @Override
    public Disciplina toDomain(DisciplinaEntity alunoEntity) {
        if ( alunoEntity == null ) {
            return null;
        }

        Disciplina disciplina = new Disciplina();

        return disciplina;
    }

    @Override
    public List<Disciplina> toDomain(List<DisciplinaEntity> DisciplinaEntities) {
        if ( DisciplinaEntities == null ) {
            return null;
        }

        List<Disciplina> list = new ArrayList<Disciplina>( DisciplinaEntities.size() );
        for ( DisciplinaEntity disciplinaEntity : DisciplinaEntities ) {
            list.add( toDomain( disciplinaEntity ) );
        }

        return list;
    }

    @Override
    public List<DisciplinaEntity> toEntity(List<Disciplina> Disciplina) {
        if ( Disciplina == null ) {
            return null;
        }

        List<DisciplinaEntity> list = new ArrayList<DisciplinaEntity>( Disciplina.size() );
        for ( Disciplina disciplina : Disciplina ) {
            list.add( toEntity( disciplina ) );
        }

        return list;
    }
}
