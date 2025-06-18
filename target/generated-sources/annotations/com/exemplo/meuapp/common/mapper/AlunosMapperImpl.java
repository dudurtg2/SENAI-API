package com.exemplo.meuapp.common.mapper;

import com.exemplo.meuapp.domain.model.Alunos;
import com.exemplo.meuapp.domain.model.Curso;
import com.exemplo.meuapp.domain.model.Endereco;
import com.exemplo.meuapp.domain.model.Usuarios;
import com.exemplo.meuapp.infrastructure.persistence.entity.AlunosEntity;
import com.exemplo.meuapp.infrastructure.persistence.entity.CursoEntity;
import com.exemplo.meuapp.infrastructure.persistence.entity.EnderecoEntity;
import com.exemplo.meuapp.infrastructure.persistence.entity.UsuariosEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-18T00:01:58-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 21.0.4 (Oracle Corporation)"
)
@Component
public class AlunosMapperImpl implements AlunosMapper {

    @Override
    public AlunosEntity toEntity(Alunos alunos) {
        if ( alunos == null ) {
            return null;
        }

        AlunosEntity.AlunosEntityBuilder alunosEntity = AlunosEntity.builder();

        alunosEntity.uuid( alunos.getUuid() );
        alunosEntity.usuarios( usuariosToUsuariosEntity( alunos.getUsuarios() ) );
        alunosEntity.endereco( enderecoToEnderecoEntity( alunos.getEndereco() ) );
        alunosEntity.matricula( alunos.getMatricula() );
        alunosEntity.curso( cursoToCursoEntity( alunos.getCurso() ) );
        alunosEntity.telefonePessoal( alunos.getTelefonePessoal() );
        alunosEntity.telefoneProfissional( alunos.getTelefoneProfissional() );
        alunosEntity.linkedin( alunos.getLinkedin() );
        alunosEntity.status( alunos.getStatus() );
        alunosEntity.criadoEm( alunos.getCriadoEm() );
        alunosEntity.atualizadoEm( alunos.getAtualizadoEm() );

        return alunosEntity.build();
    }

    @Override
    public Alunos toDomain(AlunosEntity alunosEntity) {
        if ( alunosEntity == null ) {
            return null;
        }

        Alunos.AlunosBuilder alunos = Alunos.builder();

        alunos.uuid( alunosEntity.getUuid() );
        alunos.usuarios( usuariosEntityToUsuarios( alunosEntity.getUsuarios() ) );
        alunos.matricula( alunosEntity.getMatricula() );
        alunos.curso( cursoEntityToCurso( alunosEntity.getCurso() ) );
        alunos.telefonePessoal( alunosEntity.getTelefonePessoal() );
        alunos.telefoneProfissional( alunosEntity.getTelefoneProfissional() );
        alunos.linkedin( alunosEntity.getLinkedin() );
        alunos.endereco( enderecoEntityToEndereco( alunosEntity.getEndereco() ) );
        alunos.status( alunosEntity.getStatus() );
        alunos.criadoEm( alunosEntity.getCriadoEm() );
        alunos.atualizadoEm( alunosEntity.getAtualizadoEm() );

        return alunos.build();
    }

    @Override
    public List<Alunos> toDomain(List<AlunosEntity> alunosEntities) {
        if ( alunosEntities == null ) {
            return null;
        }

        List<Alunos> list = new ArrayList<Alunos>( alunosEntities.size() );
        for ( AlunosEntity alunosEntity : alunosEntities ) {
            list.add( toDomain( alunosEntity ) );
        }

        return list;
    }

    @Override
    public List<AlunosEntity> toEntity(List<Alunos> alunos) {
        if ( alunos == null ) {
            return null;
        }

        List<AlunosEntity> list = new ArrayList<AlunosEntity>( alunos.size() );
        for ( Alunos alunos1 : alunos ) {
            list.add( toEntity( alunos1 ) );
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

    protected CursoEntity cursoToCursoEntity(Curso curso) {
        if ( curso == null ) {
            return null;
        }

        CursoEntity.CursoEntityBuilder cursoEntity = CursoEntity.builder();

        cursoEntity.uuid( curso.getUuid() );
        cursoEntity.nome( curso.getNome() );
        cursoEntity.descricao( curso.getDescricao() );
        cursoEntity.cargaHoraria( curso.getCargaHoraria() );

        return cursoEntity.build();
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

    protected Curso cursoEntityToCurso(CursoEntity cursoEntity) {
        if ( cursoEntity == null ) {
            return null;
        }

        Curso.CursoBuilder curso = Curso.builder();

        curso.uuid( cursoEntity.getUuid() );
        curso.nome( cursoEntity.getNome() );
        curso.descricao( cursoEntity.getDescricao() );
        curso.cargaHoraria( cursoEntity.getCargaHoraria() );

        return curso.build();
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
