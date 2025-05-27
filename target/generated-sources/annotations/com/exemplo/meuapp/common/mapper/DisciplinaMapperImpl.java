package com.exemplo.meuapp.common.mapper;

import com.exemplo.meuapp.domain.model.Disciplina;
import com.exemplo.meuapp.domain.model.Endereco;
import com.exemplo.meuapp.domain.model.Professores;
import com.exemplo.meuapp.infrastructure.persistence.entity.DisciplinaEntity;
import com.exemplo.meuapp.infrastructure.persistence.entity.EnderecoEntity;
import com.exemplo.meuapp.infrastructure.persistence.entity.ProfessoresEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-27T00:56:33-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 22.0.2 (Oracle Corporation)"
)
@Component
public class DisciplinaMapperImpl implements DisciplinaMapper {

    @Override
    public DisciplinaEntity toEntity(Disciplina aluno) {
        if ( aluno == null ) {
            return null;
        }

        DisciplinaEntity.DisciplinaEntityBuilder disciplinaEntity = DisciplinaEntity.builder();

        disciplinaEntity.uuid( aluno.getUuid() );
        disciplinaEntity.nome( aluno.getNome() );
        disciplinaEntity.professor( professoresToProfessoresEntity( aluno.getProfessor() ) );
        disciplinaEntity.criadoEm( aluno.getCriadoEm() );
        disciplinaEntity.atualizadoEm( aluno.getAtualizadoEm() );

        return disciplinaEntity.build();
    }

    @Override
    public Disciplina toDomain(DisciplinaEntity alunoEntity) {
        if ( alunoEntity == null ) {
            return null;
        }

        Disciplina.DisciplinaBuilder disciplina = Disciplina.builder();

        disciplina.uuid( alunoEntity.getUuid() );
        disciplina.nome( alunoEntity.getNome() );
        disciplina.professor( professoresEntityToProfessores( alunoEntity.getProfessor() ) );
        disciplina.criadoEm( alunoEntity.getCriadoEm() );
        disciplina.atualizadoEm( alunoEntity.getAtualizadoEm() );

        return disciplina.build();
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

    protected ProfessoresEntity professoresToProfessoresEntity(Professores professores) {
        if ( professores == null ) {
            return null;
        }

        ProfessoresEntity.ProfessoresEntityBuilder professoresEntity = ProfessoresEntity.builder();

        professoresEntity.uuid( professores.getUuid() );
        professoresEntity.especialidade( professores.getEspecialidade() );
        professoresEntity.departamento( professores.getDepartamento() );
        professoresEntity.telefonePessoal( professores.getTelefonePessoal() );
        professoresEntity.telefoneProfissional( professores.getTelefoneProfissional() );
        professoresEntity.linkedin( professores.getLinkedin() );
        professoresEntity.endereco( enderecoToEnderecoEntity( professores.getEndereco() ) );
        professoresEntity.status( professores.getStatus() );
        professoresEntity.criadoEm( professores.getCriadoEm() );
        professoresEntity.atualizadoEm( professores.getAtualizadoEm() );

        return professoresEntity.build();
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

    protected Professores professoresEntityToProfessores(ProfessoresEntity professoresEntity) {
        if ( professoresEntity == null ) {
            return null;
        }

        Professores.ProfessoresBuilder professores = Professores.builder();

        professores.uuid( professoresEntity.getUuid() );
        professores.especialidade( professoresEntity.getEspecialidade() );
        professores.departamento( professoresEntity.getDepartamento() );
        professores.telefonePessoal( professoresEntity.getTelefonePessoal() );
        professores.telefoneProfissional( professoresEntity.getTelefoneProfissional() );
        professores.linkedin( professoresEntity.getLinkedin() );
        professores.endereco( enderecoEntityToEndereco( professoresEntity.getEndereco() ) );
        professores.status( professoresEntity.getStatus() );
        professores.criadoEm( professoresEntity.getCriadoEm() );
        professores.atualizadoEm( professoresEntity.getAtualizadoEm() );

        return professores.build();
    }
}
