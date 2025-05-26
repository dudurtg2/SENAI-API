package com.exemplo.meuapp.common.mapper;

import com.exemplo.meuapp.domain.model.Usuarios;
import com.exemplo.meuapp.infrastructure.persistence.entity.UsuariosEntity;
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
public class UsuariosMapperImpl implements UsuariosMapper {

    @Override
    public UsuariosEntity toEntity(Usuarios aluno) {
        if ( aluno == null ) {
            return null;
        }

        UsuariosEntity usuariosEntity = new UsuariosEntity();

        return usuariosEntity;
    }

    @Override
    public Usuarios toDomain(UsuariosEntity alunoEntity) {
        if ( alunoEntity == null ) {
            return null;
        }

        Usuarios usuarios = new Usuarios();

        return usuarios;
    }

    @Override
    public List<Usuarios> toDomain(List<UsuariosEntity> UsuariosEntities) {
        if ( UsuariosEntities == null ) {
            return null;
        }

        List<Usuarios> list = new ArrayList<Usuarios>( UsuariosEntities.size() );
        for ( UsuariosEntity usuariosEntity : UsuariosEntities ) {
            list.add( toDomain( usuariosEntity ) );
        }

        return list;
    }

    @Override
    public List<UsuariosEntity> toEntity(List<Usuarios> Usuarios) {
        if ( Usuarios == null ) {
            return null;
        }

        List<UsuariosEntity> list = new ArrayList<UsuariosEntity>( Usuarios.size() );
        for ( Usuarios usuarios : Usuarios ) {
            list.add( toEntity( usuarios ) );
        }

        return list;
    }
}
