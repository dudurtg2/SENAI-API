package com.exemplo.meuapp.common.mapper;

import com.exemplo.meuapp.domain.model.Projeto;
import com.exemplo.meuapp.infrastructure.persistence.entity.ProjetoEntity;
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
public class ProjetoMapperImpl implements ProjetoMapper {

    @Override
    public ProjetoEntity toEntity(Projeto aluno) {
        if ( aluno == null ) {
            return null;
        }

        ProjetoEntity projetoEntity = new ProjetoEntity();

        return projetoEntity;
    }

    @Override
    public Projeto toDomain(ProjetoEntity alunoEntity) {
        if ( alunoEntity == null ) {
            return null;
        }

        Projeto projeto = new Projeto();

        return projeto;
    }

    @Override
    public List<Projeto> toDomain(List<ProjetoEntity> ProjetoEntities) {
        if ( ProjetoEntities == null ) {
            return null;
        }

        List<Projeto> list = new ArrayList<Projeto>( ProjetoEntities.size() );
        for ( ProjetoEntity projetoEntity : ProjetoEntities ) {
            list.add( toDomain( projetoEntity ) );
        }

        return list;
    }

    @Override
    public List<ProjetoEntity> toEntity(List<Projeto> Projeto) {
        if ( Projeto == null ) {
            return null;
        }

        List<ProjetoEntity> list = new ArrayList<ProjetoEntity>( Projeto.size() );
        for ( Projeto projeto : Projeto ) {
            list.add( toEntity( projeto ) );
        }

        return list;
    }
}
