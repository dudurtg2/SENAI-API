package com.exemplo.meuapp.common.mapper;

import com.exemplo.meuapp.domain.model.DisciplinaProjeto;
import com.exemplo.meuapp.infrastructure.persistence.entity.DisciplinaProjetoEntity;
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
public class DisciplinaProjetoMapperImpl implements DisciplinaProjetoMapper {

    @Override
    public DisciplinaProjetoEntity toEntity(DisciplinaProjeto aluno) {
        if ( aluno == null ) {
            return null;
        }

        DisciplinaProjetoEntity disciplinaProjetoEntity = new DisciplinaProjetoEntity();

        return disciplinaProjetoEntity;
    }

    @Override
    public DisciplinaProjeto toDomain(DisciplinaProjetoEntity alunoEntity) {
        if ( alunoEntity == null ) {
            return null;
        }

        DisciplinaProjeto disciplinaProjeto = new DisciplinaProjeto();

        return disciplinaProjeto;
    }

    @Override
    public List<DisciplinaProjeto> toDomain(List<DisciplinaProjetoEntity> DisciplinaProjetoEntities) {
        if ( DisciplinaProjetoEntities == null ) {
            return null;
        }

        List<DisciplinaProjeto> list = new ArrayList<DisciplinaProjeto>( DisciplinaProjetoEntities.size() );
        for ( DisciplinaProjetoEntity disciplinaProjetoEntity : DisciplinaProjetoEntities ) {
            list.add( toDomain( disciplinaProjetoEntity ) );
        }

        return list;
    }

    @Override
    public List<DisciplinaProjetoEntity> toEntity(List<DisciplinaProjeto> DisciplinaProjeto) {
        if ( DisciplinaProjeto == null ) {
            return null;
        }

        List<DisciplinaProjetoEntity> list = new ArrayList<DisciplinaProjetoEntity>( DisciplinaProjeto.size() );
        for ( DisciplinaProjeto disciplinaProjeto : DisciplinaProjeto ) {
            list.add( toEntity( disciplinaProjeto ) );
        }

        return list;
    }
}
