package com.exemplo.meuapp.common.mapper;

import com.exemplo.meuapp.domain.model.Usuarios;
import com.exemplo.meuapp.infrastructure.persistence.entity.UsuariosEntity;
import com.exemplo.meuapp.presentation.dto.NovoPerfil;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-17T19:16:29-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 21.0.4 (Oracle Corporation)"
)
@Component
public class UsuariosMapperImpl implements UsuariosMapper {

    @Override
    public UsuariosEntity toEntity(Usuarios usuarios) {
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

    @Override
    public Usuarios toDomain(NovoPerfil novoPerfil) {
        if ( novoPerfil == null ) {
            return null;
        }

        Usuarios.UsuariosBuilder usuarios = Usuarios.builder();

        usuarios.usuario( novoPerfil.usuario() );
        usuarios.senha( novoPerfil.senha() );
        usuarios.email( novoPerfil.email() );
        usuarios.status( novoPerfil.status() );

        return usuarios.build();
    }

    @Override
    public Usuarios toDomain(UsuariosEntity usuariosEntity) {
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

    @Override
    public List<Usuarios> toDomain(List<UsuariosEntity> usuariosEntities) {
        if ( usuariosEntities == null ) {
            return null;
        }

        List<Usuarios> list = new ArrayList<Usuarios>( usuariosEntities.size() );
        for ( UsuariosEntity usuariosEntity : usuariosEntities ) {
            list.add( toDomain( usuariosEntity ) );
        }

        return list;
    }

    @Override
    public List<UsuariosEntity> toEntity(List<Usuarios> usuarios) {
        if ( usuarios == null ) {
            return null;
        }

        List<UsuariosEntity> list = new ArrayList<UsuariosEntity>( usuarios.size() );
        for ( Usuarios usuarios1 : usuarios ) {
            list.add( toEntity( usuarios1 ) );
        }

        return list;
    }
}
