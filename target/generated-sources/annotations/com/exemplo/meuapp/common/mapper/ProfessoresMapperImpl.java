package com.exemplo.meuapp.common.mapper;

import com.exemplo.meuapp.domain.model.Professores;
import com.exemplo.meuapp.infrastructure.persistence.entity.ProfessoresEntity;
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
public class ProfessoresMapperImpl implements ProfessoresMapper {

    @Override
    public ProfessoresEntity toEntity(Professores aluno) {
        if ( aluno == null ) {
            return null;
        }

        ProfessoresEntity professoresEntity = new ProfessoresEntity();

        return professoresEntity;
    }

    @Override
    public Professores toDomain(ProfessoresEntity alunoEntity) {
        if ( alunoEntity == null ) {
            return null;
        }

        Professores professores = new Professores();

        return professores;
    }

    @Override
    public List<Professores> toDomain(List<ProfessoresEntity> ProfessoresEntities) {
        if ( ProfessoresEntities == null ) {
            return null;
        }

        List<Professores> list = new ArrayList<Professores>( ProfessoresEntities.size() );
        for ( ProfessoresEntity professoresEntity : ProfessoresEntities ) {
            list.add( toDomain( professoresEntity ) );
        }

        return list;
    }

    @Override
    public List<ProfessoresEntity> toEntity(List<Professores> Professores) {
        if ( Professores == null ) {
            return null;
        }

        List<ProfessoresEntity> list = new ArrayList<ProfessoresEntity>( Professores.size() );
        for ( Professores professores : Professores ) {
            list.add( toEntity( professores ) );
        }

        return list;
    }
}
