package com.exemplo.meuapp.common.mapper;

import com.exemplo.meuapp.domain.model.ProjetoProfessor;
import com.exemplo.meuapp.infrastructure.persistence.entity.ProjetoProfessorEntity;
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
public class ProjetoProfessorMapperImpl implements ProjetoProfessorMapper {

    @Override
    public ProjetoProfessorEntity toEntity(ProjetoProfessor aluno) {
        if ( aluno == null ) {
            return null;
        }

        ProjetoProfessorEntity projetoProfessorEntity = new ProjetoProfessorEntity();

        return projetoProfessorEntity;
    }

    @Override
    public ProjetoProfessor toDomain(ProjetoProfessorEntity alunoEntity) {
        if ( alunoEntity == null ) {
            return null;
        }

        ProjetoProfessor projetoProfessor = new ProjetoProfessor();

        return projetoProfessor;
    }

    @Override
    public List<ProjetoProfessor> toDomain(List<ProjetoProfessorEntity> ProjetoProfessorEntities) {
        if ( ProjetoProfessorEntities == null ) {
            return null;
        }

        List<ProjetoProfessor> list = new ArrayList<ProjetoProfessor>( ProjetoProfessorEntities.size() );
        for ( ProjetoProfessorEntity projetoProfessorEntity : ProjetoProfessorEntities ) {
            list.add( toDomain( projetoProfessorEntity ) );
        }

        return list;
    }

    @Override
    public List<ProjetoProfessorEntity> toEntity(List<ProjetoProfessor> ProjetoProfessor) {
        if ( ProjetoProfessor == null ) {
            return null;
        }

        List<ProjetoProfessorEntity> list = new ArrayList<ProjetoProfessorEntity>( ProjetoProfessor.size() );
        for ( ProjetoProfessor projetoProfessor : ProjetoProfessor ) {
            list.add( toEntity( projetoProfessor ) );
        }

        return list;
    }
}
