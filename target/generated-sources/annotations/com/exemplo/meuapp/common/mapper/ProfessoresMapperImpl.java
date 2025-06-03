package com.exemplo.meuapp.common.mapper;

import com.exemplo.meuapp.domain.model.Endereco;
import com.exemplo.meuapp.domain.model.Professores;
import com.exemplo.meuapp.infrastructure.persistence.entity.EnderecoEntity;
import com.exemplo.meuapp.infrastructure.persistence.entity.ProfessoresEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-02T20:18:50-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 21.0.5 (Oracle Corporation)"
)
@Component
public class ProfessoresMapperImpl implements ProfessoresMapper {

    @Override
    public ProfessoresEntity toEntity(Professores aluno) {
        if ( aluno == null ) {
            return null;
        }

        ProfessoresEntity.ProfessoresEntityBuilder professoresEntity = ProfessoresEntity.builder();

        professoresEntity.uuid( aluno.getUuid() );
        professoresEntity.especialidade( aluno.getEspecialidade() );
        professoresEntity.departamento( aluno.getDepartamento() );
        professoresEntity.telefonePessoal( aluno.getTelefonePessoal() );
        professoresEntity.telefoneProfissional( aluno.getTelefoneProfissional() );
        professoresEntity.linkedin( aluno.getLinkedin() );
        professoresEntity.endereco( enderecoToEnderecoEntity( aluno.getEndereco() ) );
        professoresEntity.status( aluno.getStatus() );
        professoresEntity.criadoEm( aluno.getCriadoEm() );
        professoresEntity.atualizadoEm( aluno.getAtualizadoEm() );

        return professoresEntity.build();
    }

    @Override
    public Professores toDomain(ProfessoresEntity alunoEntity) {
        if ( alunoEntity == null ) {
            return null;
        }

        Professores.ProfessoresBuilder professores = Professores.builder();

        professores.uuid( alunoEntity.getUuid() );
        professores.especialidade( alunoEntity.getEspecialidade() );
        professores.departamento( alunoEntity.getDepartamento() );
        professores.telefonePessoal( alunoEntity.getTelefonePessoal() );
        professores.telefoneProfissional( alunoEntity.getTelefoneProfissional() );
        professores.linkedin( alunoEntity.getLinkedin() );
        professores.endereco( enderecoEntityToEndereco( alunoEntity.getEndereco() ) );
        professores.status( alunoEntity.getStatus() );
        professores.criadoEm( alunoEntity.getCriadoEm() );
        professores.atualizadoEm( alunoEntity.getAtualizadoEm() );

        return professores.build();
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

    protected EnderecoEntity enderecoToEnderecoEntity(Endereco endereco) {
        if ( endereco == null ) {
            return null;
        }

        EnderecoEntity.EnderecoEntityBuilder enderecoEntity = EnderecoEntity.builder();

        enderecoEntity.uuid( endereco.getUuid() );
        enderecoEntity.cep( endereco.getCep() );
        enderecoEntity.logradouro( endereco.getLogradouro() );
        enderecoEntity.numero( endereco.getNumero() );
        enderecoEntity.complemento( endereco.getComplemento() );
        enderecoEntity.bairro( endereco.getBairro() );
        enderecoEntity.cidade( endereco.getCidade() );
        enderecoEntity.estado( endereco.getEstado() );
        enderecoEntity.pais( endereco.getPais() );

        return enderecoEntity.build();
    }

    protected Endereco enderecoEntityToEndereco(EnderecoEntity enderecoEntity) {
        if ( enderecoEntity == null ) {
            return null;
        }

        Endereco.EnderecoBuilder endereco = Endereco.builder();

        endereco.uuid( enderecoEntity.getUuid() );
        endereco.cep( enderecoEntity.getCep() );
        endereco.logradouro( enderecoEntity.getLogradouro() );
        endereco.numero( enderecoEntity.getNumero() );
        endereco.complemento( enderecoEntity.getComplemento() );
        endereco.bairro( enderecoEntity.getBairro() );
        endereco.cidade( enderecoEntity.getCidade() );
        endereco.estado( enderecoEntity.getEstado() );
        endereco.pais( enderecoEntity.getPais() );

        return endereco.build();
    }
}
