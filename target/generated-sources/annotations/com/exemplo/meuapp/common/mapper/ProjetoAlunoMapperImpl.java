package com.exemplo.meuapp.common.mapper;

import com.exemplo.meuapp.domain.model.ProjetoAluno;
import com.exemplo.meuapp.infrastructure.persistence.entity.ProjetoAlunoEntity;
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
public class ProjetoAlunoMapperImpl implements ProjetoAlunoMapper {

    @Override
    public ProjetoAlunoEntity toEntity(ProjetoAluno aluno) {
        if ( aluno == null ) {
            return null;
        }

        ProjetoAlunoEntity projetoAlunoEntity = new ProjetoAlunoEntity();

        return projetoAlunoEntity;
    }

    @Override
    public ProjetoAluno toDomain(ProjetoAlunoEntity alunoEntity) {
        if ( alunoEntity == null ) {
            return null;
        }

        ProjetoAluno projetoAluno = new ProjetoAluno();

        return projetoAluno;
    }

    @Override
    public List<ProjetoAluno> toDomain(List<ProjetoAlunoEntity> ProjetoAlunoEntities) {
        if ( ProjetoAlunoEntities == null ) {
            return null;
        }

        List<ProjetoAluno> list = new ArrayList<ProjetoAluno>( ProjetoAlunoEntities.size() );
        for ( ProjetoAlunoEntity projetoAlunoEntity : ProjetoAlunoEntities ) {
            list.add( toDomain( projetoAlunoEntity ) );
        }

        return list;
    }

    @Override
    public List<ProjetoAlunoEntity> toEntity(List<ProjetoAluno> ProjetoAluno) {
        if ( ProjetoAluno == null ) {
            return null;
        }

        List<ProjetoAlunoEntity> list = new ArrayList<ProjetoAlunoEntity>( ProjetoAluno.size() );
        for ( ProjetoAluno projetoAluno : ProjetoAluno ) {
            list.add( toEntity( projetoAluno ) );
        }

        return list;
    }
}
