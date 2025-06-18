package com.exemplo.meuapp.common.mapper;

import com.exemplo.meuapp.domain.model.Endereco;
import com.exemplo.meuapp.domain.model.Professores;
import com.exemplo.meuapp.domain.model.Usuarios;
import com.exemplo.meuapp.infrastructure.persistence.entity.EnderecoEntity;
import com.exemplo.meuapp.infrastructure.persistence.entity.ProfessoresEntity;
import com.exemplo.meuapp.infrastructure.persistence.entity.UsuariosEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-18T13:44:08-0300",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.42.0.v20250514-1000, environment: Java 21.0.7 (Eclipse Adoptium)"
)
@Component
public class ProfessoresMapperImpl implements ProfessoresMapper {

    @Override
    public ProfessoresEntity toEntity(Professores aluno) {
        if ( aluno == null ) {
            return null;
        }

        ProfessoresEntity.ProfessoresEntityBuilder professoresEntity = ProfessoresEntity.builder();

        professoresEntity.atualizadoEm( aluno.getAtualizadoEm() );
        professoresEntity.criadoEm( aluno.getCriadoEm() );
        professoresEntity.departamento( aluno.getDepartamento() );
        professoresEntity.endereco( enderecoToEnderecoEntity( aluno.getEndereco() ) );
        professoresEntity.especialidade( aluno.getEspecialidade() );
        professoresEntity.linkedin( aluno.getLinkedin() );
        professoresEntity.status( aluno.getStatus() );
        professoresEntity.telefonePessoal( aluno.getTelefonePessoal() );
        professoresEntity.telefoneProfissional( aluno.getTelefoneProfissional() );
        professoresEntity.usuarios( usuariosToUsuariosEntity( aluno.getUsuarios() ) );
        professoresEntity.uuid( aluno.getUuid() );

        return professoresEntity.build();
    }

    @Override
    public Professores toDomain(ProfessoresEntity alunoEntity) {
        if ( alunoEntity == null ) {
            return null;
        }

        Professores.ProfessoresBuilder professores = Professores.builder();

        professores.atualizadoEm( alunoEntity.getAtualizadoEm() );
        professores.criadoEm( alunoEntity.getCriadoEm() );
        professores.departamento( alunoEntity.getDepartamento() );
        professores.endereco( enderecoEntityToEndereco( alunoEntity.getEndereco() ) );
        professores.especialidade( alunoEntity.getEspecialidade() );
        professores.linkedin( alunoEntity.getLinkedin() );
        professores.status( alunoEntity.getStatus() );
        professores.telefonePessoal( alunoEntity.getTelefonePessoal() );
        professores.telefoneProfissional( alunoEntity.getTelefoneProfissional() );
        professores.usuarios( usuariosEntityToUsuarios( alunoEntity.getUsuarios() ) );
        professores.uuid( alunoEntity.getUuid() );

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
}
