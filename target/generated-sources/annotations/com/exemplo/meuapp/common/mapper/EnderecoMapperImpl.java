package com.exemplo.meuapp.common.mapper;

import com.exemplo.meuapp.domain.model.Endereco;
import com.exemplo.meuapp.infrastructure.persistence.entity.EnderecoEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-18T14:11:45-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 21.0.5 (Oracle Corporation)"
)
@Component
public class EnderecoMapperImpl implements EnderecoMapper {

    @Override
    public EnderecoEntity toEntity(Endereco aluno) {
        if ( aluno == null ) {
            return null;
        }

        EnderecoEntity.EnderecoEntityBuilder enderecoEntity = EnderecoEntity.builder();

        enderecoEntity.uuid( aluno.getUuid() );
        enderecoEntity.cep( aluno.getCep() );
        enderecoEntity.logradouro( aluno.getLogradouro() );
        enderecoEntity.numero( aluno.getNumero() );
        enderecoEntity.complemento( aluno.getComplemento() );
        enderecoEntity.bairro( aluno.getBairro() );
        enderecoEntity.cidade( aluno.getCidade() );
        enderecoEntity.estado( aluno.getEstado() );
        enderecoEntity.pais( aluno.getPais() );

        return enderecoEntity.build();
    }

    @Override
    public Endereco toDomain(EnderecoEntity alunoEntity) {
        if ( alunoEntity == null ) {
            return null;
        }

        Endereco.EnderecoBuilder endereco = Endereco.builder();

        endereco.uuid( alunoEntity.getUuid() );
        endereco.cep( alunoEntity.getCep() );
        endereco.logradouro( alunoEntity.getLogradouro() );
        endereco.numero( alunoEntity.getNumero() );
        endereco.complemento( alunoEntity.getComplemento() );
        endereco.bairro( alunoEntity.getBairro() );
        endereco.cidade( alunoEntity.getCidade() );
        endereco.estado( alunoEntity.getEstado() );
        endereco.pais( alunoEntity.getPais() );

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
