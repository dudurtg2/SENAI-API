package com.exemplo.meuapp.common.mapper;

import com.exemplo.meuapp.domain.model.Disciplina;
import com.exemplo.meuapp.domain.model.Endereco;
import com.exemplo.meuapp.domain.model.Professores;
import com.exemplo.meuapp.domain.model.Usuarios;
import com.exemplo.meuapp.infrastructure.persistence.entity.DisciplinaEntity;
import com.exemplo.meuapp.infrastructure.persistence.entity.EnderecoEntity;
import com.exemplo.meuapp.infrastructure.persistence.entity.ProfessoresEntity;
import com.exemplo.meuapp.infrastructure.persistence.entity.UsuariosEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-18T13:44:09-0300",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.42.0.v20250514-1000, environment: Java 21.0.7 (Eclipse Adoptium)"
)
@Component
public class DisciplinaMapperImpl implements DisciplinaMapper {

    @Override
    public DisciplinaEntity toEntity(Disciplina aluno) {
        if ( aluno == null ) {
            return null;
        }

        DisciplinaEntity.DisciplinaEntityBuilder disciplinaEntity = DisciplinaEntity.builder();

        disciplinaEntity.atualizadoEm( aluno.getAtualizadoEm() );
        disciplinaEntity.criadoEm( aluno.getCriadoEm() );
        disciplinaEntity.nome( aluno.getNome() );
        disciplinaEntity.professor( professoresToProfessoresEntity( aluno.getProfessor() ) );
        disciplinaEntity.uuid( aluno.getUuid() );

        return disciplinaEntity.build();
    }

    @Override
    public Disciplina toDomain(DisciplinaEntity alunoEntity) {
        if ( alunoEntity == null ) {
            return null;
        }

        Disciplina.DisciplinaBuilder disciplina = Disciplina.builder();

        disciplina.atualizadoEm( alunoEntity.getAtualizadoEm() );
        disciplina.criadoEm( alunoEntity.getCriadoEm() );
        disciplina.nome( alunoEntity.getNome() );
        disciplina.professor( professoresEntityToProfessores( alunoEntity.getProfessor() ) );
        disciplina.uuid( alunoEntity.getUuid() );

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

        enderecoEntity.bairro( endereco.getBairro() );
        enderecoEntity.cep( endereco.getCep() );
        enderecoEntity.cidade( endereco.getCidade() );
        enderecoEntity.complemento( endereco.getComplemento() );
        enderecoEntity.estado( endereco.getEstado() );
        enderecoEntity.logradouro( endereco.getLogradouro() );
        enderecoEntity.numero( endereco.getNumero() );
        enderecoEntity.pais( endereco.getPais() );
        enderecoEntity.uuid( endereco.getUuid() );

        return enderecoEntity.build();
    }

    protected UsuariosEntity usuariosToUsuariosEntity(Usuarios usuarios) {
        if ( usuarios == null ) {
            return null;
        }

        UsuariosEntity.UsuariosEntityBuilder usuariosEntity = UsuariosEntity.builder();

        usuariosEntity.atualizadoEm( usuarios.getAtualizadoEm() );
        usuariosEntity.criadoEm( usuarios.getCriadoEm() );
        usuariosEntity.email( usuarios.getEmail() );
        usuariosEntity.senha( usuarios.getSenha() );
        usuariosEntity.status( usuarios.getStatus() );
        usuariosEntity.tipo( usuarios.getTipo() );
        usuariosEntity.usuario( usuarios.getUsuario() );
        usuariosEntity.uuid( usuarios.getUuid() );

        return usuariosEntity.build();
    }

    protected ProfessoresEntity professoresToProfessoresEntity(Professores professores) {
        if ( professores == null ) {
            return null;
        }

        ProfessoresEntity.ProfessoresEntityBuilder professoresEntity = ProfessoresEntity.builder();

        professoresEntity.atualizadoEm( professores.getAtualizadoEm() );
        professoresEntity.criadoEm( professores.getCriadoEm() );
        professoresEntity.departamento( professores.getDepartamento() );
        professoresEntity.endereco( enderecoToEnderecoEntity( professores.getEndereco() ) );
        professoresEntity.especialidade( professores.getEspecialidade() );
        professoresEntity.linkedin( professores.getLinkedin() );
        professoresEntity.status( professores.getStatus() );
        professoresEntity.telefonePessoal( professores.getTelefonePessoal() );
        professoresEntity.telefoneProfissional( professores.getTelefoneProfissional() );
        professoresEntity.usuarios( usuariosToUsuariosEntity( professores.getUsuarios() ) );
        professoresEntity.uuid( professores.getUuid() );

        return professoresEntity.build();
    }

    protected Endereco enderecoEntityToEndereco(EnderecoEntity enderecoEntity) {
        if ( enderecoEntity == null ) {
            return null;
        }

        Endereco.EnderecoBuilder endereco = Endereco.builder();

        endereco.bairro( enderecoEntity.getBairro() );
        endereco.cep( enderecoEntity.getCep() );
        endereco.cidade( enderecoEntity.getCidade() );
        endereco.complemento( enderecoEntity.getComplemento() );
        endereco.estado( enderecoEntity.getEstado() );
        endereco.logradouro( enderecoEntity.getLogradouro() );
        endereco.numero( enderecoEntity.getNumero() );
        endereco.pais( enderecoEntity.getPais() );
        endereco.uuid( enderecoEntity.getUuid() );

        return endereco.build();
    }

    protected Usuarios usuariosEntityToUsuarios(UsuariosEntity usuariosEntity) {
        if ( usuariosEntity == null ) {
            return null;
        }

        Usuarios.UsuariosBuilder usuarios = Usuarios.builder();

        usuarios.atualizadoEm( usuariosEntity.getAtualizadoEm() );
        usuarios.criadoEm( usuariosEntity.getCriadoEm() );
        usuarios.email( usuariosEntity.getEmail() );
        usuarios.senha( usuariosEntity.getSenha() );
        usuarios.status( usuariosEntity.getStatus() );
        usuarios.tipo( usuariosEntity.getTipo() );
        usuarios.usuario( usuariosEntity.getUsuario() );
        usuarios.uuid( usuariosEntity.getUuid() );

        return usuarios.build();
    }

    protected Professores professoresEntityToProfessores(ProfessoresEntity professoresEntity) {
        if ( professoresEntity == null ) {
            return null;
        }

        Professores.ProfessoresBuilder professores = Professores.builder();

        professores.atualizadoEm( professoresEntity.getAtualizadoEm() );
        professores.criadoEm( professoresEntity.getCriadoEm() );
        professores.departamento( professoresEntity.getDepartamento() );
        professores.endereco( enderecoEntityToEndereco( professoresEntity.getEndereco() ) );
        professores.especialidade( professoresEntity.getEspecialidade() );
        professores.linkedin( professoresEntity.getLinkedin() );
        professores.status( professoresEntity.getStatus() );
        professores.telefonePessoal( professoresEntity.getTelefonePessoal() );
        professores.telefoneProfissional( professoresEntity.getTelefoneProfissional() );
        professores.usuarios( usuariosEntityToUsuarios( professoresEntity.getUsuarios() ) );
        professores.uuid( professoresEntity.getUuid() );

        return professores.build();
    }
}
