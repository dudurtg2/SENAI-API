package com.exemplo.meuapp.common.mapper;

import com.exemplo.meuapp.domain.model.Endereco;
import com.exemplo.meuapp.infrastructure.persistence.entity.EnderecoEntity;
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
public class EnderecoMapperImpl implements EnderecoMapper {

    @Override
    public EnderecoEntity toEntity(Endereco aluno) {
        if ( aluno == null ) {
            return null;
        }

        EnderecoEntity enderecoEntity = new EnderecoEntity();

        return enderecoEntity;
    }

    @Override
    public Endereco toDomain(EnderecoEntity alunoEntity) {
        if ( alunoEntity == null ) {
            return null;
        }

        Endereco endereco = new Endereco();

        return endereco;
    }

    @Override
    public List<Endereco> toDomain(List<EnderecoEntity> EnderecoEntities) {
        if ( EnderecoEntities == null ) {
            return null;
        }

        List<Endereco> list = new ArrayList<Endereco>( EnderecoEntities.size() );
        for ( EnderecoEntity enderecoEntity : EnderecoEntities ) {
            list.add( toDomain( enderecoEntity ) );
        }

        return list;
    }

    @Override
    public List<EnderecoEntity> toEntity(List<Endereco> Endereco) {
        if ( Endereco == null ) {
            return null;
        }

        List<EnderecoEntity> list = new ArrayList<EnderecoEntity>( Endereco.size() );
        for ( Endereco endereco : Endereco ) {
            list.add( toEntity( endereco ) );
        }

        return list;
    }
}
