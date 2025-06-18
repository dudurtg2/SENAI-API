package com.exemplo.meuapp.common.mapper;

import com.exemplo.meuapp.domain.model.Endereco;
import com.exemplo.meuapp.infrastructure.persistence.entity.EnderecoEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-18T13:44:07-0300",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.42.0.v20250514-1000, environment: Java 21.0.7 (Eclipse Adoptium)"
)
@Component
public class EnderecoMapperImpl implements EnderecoMapper {

    @Override
    public EnderecoEntity toEntity(Endereco aluno) {
        if ( aluno == null ) {
            return null;
        }

        EnderecoEntity.EnderecoEntityBuilder enderecoEntity = EnderecoEntity.builder();

        enderecoEntity.bairro( aluno.getBairro() );
        enderecoEntity.cep( aluno.getCep() );
        enderecoEntity.cidade( aluno.getCidade() );
        enderecoEntity.complemento( aluno.getComplemento() );
        enderecoEntity.estado( aluno.getEstado() );
        enderecoEntity.logradouro( aluno.getLogradouro() );
        enderecoEntity.numero( aluno.getNumero() );
        enderecoEntity.pais( aluno.getPais() );
        enderecoEntity.uuid( aluno.getUuid() );

        return enderecoEntity.build();
    }

    @Override
    public Endereco toDomain(EnderecoEntity alunoEntity) {
        if ( alunoEntity == null ) {
            return null;
        }

        Endereco.EnderecoBuilder endereco = Endereco.builder();

        endereco.bairro( alunoEntity.getBairro() );
        endereco.cep( alunoEntity.getCep() );
        endereco.cidade( alunoEntity.getCidade() );
        endereco.complemento( alunoEntity.getComplemento() );
        endereco.estado( alunoEntity.getEstado() );
        endereco.logradouro( alunoEntity.getLogradouro() );
        endereco.numero( alunoEntity.getNumero() );
        endereco.pais( alunoEntity.getPais() );
        endereco.uuid( alunoEntity.getUuid() );

        return endereco.build();
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
