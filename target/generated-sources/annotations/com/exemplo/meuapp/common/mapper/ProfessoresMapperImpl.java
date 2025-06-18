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
    date = "2025-06-18T14:11:45-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 21.0.5 (Oracle Corporation)"
)
@Component
public class ProfessoresMapperImpl implements ProfessoresMapper {

    @Override
    public ProfessoresEntity toEntity(Professores professores) {
        if ( professores == null ) {
            return null;
        }

        ProfessoresEntity.ProfessoresEntityBuilder professoresEntity = ProfessoresEntity.builder();

        professoresEntity.uuid( professores.getUuid() );
        professoresEntity.usuarios( usuariosToUsuariosEntity( professores.getUsuarios() ) );
        professoresEntity.endereco( enderecoToEnderecoEntity( professores.getEndereco() ) );
        professoresEntity.especialidade( professores.getEspecialidade() );
        professoresEntity.departamento( professores.getDepartamento() );
        professoresEntity.telefonePessoal( professores.getTelefonePessoal() );
        professoresEntity.telefoneProfissional( professores.getTelefoneProfissional() );
        professoresEntity.linkedin( professores.getLinkedin() );
        professoresEntity.status( professores.getStatus() );
        professoresEntity.criadoEm( professores.getCriadoEm() );
        professoresEntity.atualizadoEm( professores.getAtualizadoEm() );

        return professoresEntity.build();
    }

    @Override
    public Professores toDomain(ProfessoresEntity professoresEntity) {
        if ( professoresEntity == null ) {
            return null;
        }

        Professores.ProfessoresBuilder professores = Professores.builder();

        professores.uuid( professoresEntity.getUuid() );
        professores.usuarios( usuariosEntityToUsuarios( professoresEntity.getUsuarios() ) );
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

    @Override
    public List<Professores> toDomain(List<ProfessoresEntity> professoresEntityList) {
        if ( professoresEntityList == null ) {
            return null;
        }

        List<Professores> list = new ArrayList<Professores>( professoresEntityList.size() );
        for ( ProfessoresEntity professoresEntity : professoresEntityList ) {
            list.add( toDomain( professoresEntity ) );
        }

        return list;
    }

    @Override
    public List<ProfessoresEntity> toEntity(List<Professores> professoresList) {
        if ( professoresList == null ) {
            return null;
        }

        List<ProfessoresEntity> list = new ArrayList<ProfessoresEntity>( professoresList.size() );
        for ( Professores professores : professoresList ) {
            list.add( toEntity( professores ) );
        }

        return list;
    }

    protected UsuariosEntity usuariosToUsuariosEntity(Usuarios usuarios) {
        if ( usuarios == null ) {
            return null;
        }

        UsuariosEntity.UsuariosEntityBuilder usuariosEntity = UsuariosEntity.builder();

        usuariosEntity.uuid( usuarios.getUuid() );
        usuariosEntity.usuario( usuarios.getUsuario() );
        usuariosEntity.senha( usuarios.getSenha() );
        usuariosEntity.email( usuarios.getEmail() );
        usuariosEntity.tipo( usuarios.getTipo() );
        usuariosEntity.status( usuarios.getStatus() );
        usuariosEntity.criadoEm( usuarios.getCriadoEm() );
        usuariosEntity.atualizadoEm( usuarios.getAtualizadoEm() );

        return usuariosEntity.build();
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

    protected Usuarios usuariosEntityToUsuarios(UsuariosEntity usuariosEntity) {
        if ( usuariosEntity == null ) {
            return null;
        }

        Usuarios.UsuariosBuilder usuarios = Usuarios.builder();

        usuarios.uuid( usuariosEntity.getUuid() );
        usuarios.usuario( usuariosEntity.getUsuario() );
        usuarios.senha( usuariosEntity.getSenha() );
        usuarios.email( usuariosEntity.getEmail() );
        usuarios.tipo( usuariosEntity.getTipo() );
        usuarios.status( usuariosEntity.getStatus() );
        usuarios.criadoEm( usuariosEntity.getCriadoEm() );
        usuarios.atualizadoEm( usuariosEntity.getAtualizadoEm() );

        return usuarios.build();
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
