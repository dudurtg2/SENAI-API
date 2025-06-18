package com.exemplo.meuapp.common.mapper;

import com.exemplo.meuapp.domain.model.Alunos;
import com.exemplo.meuapp.domain.model.Endereco;
import com.exemplo.meuapp.domain.model.Projeto;
import com.exemplo.meuapp.domain.model.UnidadeCurricular;
import com.exemplo.meuapp.domain.model.Usuarios;
import com.exemplo.meuapp.infrastructure.persistence.entity.AlunosEntity;
import com.exemplo.meuapp.infrastructure.persistence.entity.EnderecoEntity;
import com.exemplo.meuapp.infrastructure.persistence.entity.ProjetoEntity;
import com.exemplo.meuapp.infrastructure.persistence.entity.UnidadeCurricularEntity;
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
public class ProjetoMapperImpl implements ProjetoMapper {

    @Override
    public ProjetoEntity toEntity(Projeto aluno) {
        if ( aluno == null ) {
            return null;
        }

        ProjetoEntity.ProjetoEntityBuilder projetoEntity = ProjetoEntity.builder();

        projetoEntity.atualizadoEm( aluno.getAtualizadoEm() );
        projetoEntity.bannerUrl( aluno.getBannerUrl() );
        projetoEntity.codigo( aluno.getCodigo() );
        projetoEntity.criadoEm( aluno.getCriadoEm() );
        projetoEntity.curso( aluno.getCurso() );
        projetoEntity.descricao( aluno.getDescricao() );
        projetoEntity.itinerario( aluno.isItinerario() );
        projetoEntity.labMaker( aluno.isLabMaker() );
        projetoEntity.liderProjeto( alunosToAlunosEntity( aluno.getLiderProjeto() ) );
        projetoEntity.participouSaga( aluno.isParticipouSaga() );
        projetoEntity.status( aluno.getStatus() );
        projetoEntity.titulo( aluno.getTitulo() );
        projetoEntity.turma( aluno.getTurma() );
        projetoEntity.unidadeCurricular( unidadeCurricularToUnidadeCurricularEntity( aluno.getUnidadeCurricular() ) );
        projetoEntity.uuid( aluno.getUuid() );
        projetoEntity.visibilidadeAnexos( aluno.getVisibilidadeAnexos() );
        projetoEntity.visibilidadeCodigo( aluno.getVisibilidadeCodigo() );

        return projetoEntity.build();
    }

    @Override
    public Projeto toDomain(ProjetoEntity alunoEntity) {
        if ( alunoEntity == null ) {
            return null;
        }

        Projeto.ProjetoBuilder projeto = Projeto.builder();

        projeto.atualizadoEm( alunoEntity.getAtualizadoEm() );
        projeto.bannerUrl( alunoEntity.getBannerUrl() );
        projeto.codigo( alunoEntity.getCodigo() );
        projeto.criadoEm( alunoEntity.getCriadoEm() );
        projeto.curso( alunoEntity.getCurso() );
        projeto.descricao( alunoEntity.getDescricao() );
        projeto.itinerario( alunoEntity.isItinerario() );
        projeto.labMaker( alunoEntity.isLabMaker() );
        projeto.liderProjeto( alunosEntityToAlunos( alunoEntity.getLiderProjeto() ) );
        projeto.participouSaga( alunoEntity.isParticipouSaga() );
        projeto.status( alunoEntity.getStatus() );
        projeto.titulo( alunoEntity.getTitulo() );
        projeto.turma( alunoEntity.getTurma() );
        projeto.unidadeCurricular( unidadeCurricularEntityToUnidadeCurricular( alunoEntity.getUnidadeCurricular() ) );
        projeto.uuid( alunoEntity.getUuid() );
        projeto.visibilidadeAnexos( alunoEntity.getVisibilidadeAnexos() );
        projeto.visibilidadeCodigo( alunoEntity.getVisibilidadeCodigo() );

        return projeto.build();
    }

    @Override
    public List<Projeto> toDomain(List<ProjetoEntity> ProjetoEntities) {
        if ( ProjetoEntities == null ) {
            return null;
        }

        List<Projeto> list = new ArrayList<Projeto>( ProjetoEntities.size() );
        for ( ProjetoEntity projetoEntity : ProjetoEntities ) {
            list.add( toDomain( projetoEntity ) );
        }

        return list;
    }

    @Override
    public List<ProjetoEntity> toEntity(List<Projeto> Projeto) {
        if ( Projeto == null ) {
            return null;
        }

        List<ProjetoEntity> list = new ArrayList<ProjetoEntity>( Projeto.size() );
        for ( Projeto projeto : Projeto ) {
            list.add( toEntity( projeto ) );
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

    protected AlunosEntity alunosToAlunosEntity(Alunos alunos) {
        if ( alunos == null ) {
            return null;
        }

        AlunosEntity.AlunosEntityBuilder alunosEntity = AlunosEntity.builder();

        alunosEntity.atualizadoEm( alunos.getAtualizadoEm() );
        alunosEntity.criadoEm( alunos.getCriadoEm() );
        alunosEntity.curso( alunos.getCurso() );
        alunosEntity.endereco( enderecoToEnderecoEntity( alunos.getEndereco() ) );
        alunosEntity.linkedin( alunos.getLinkedin() );
        alunosEntity.matricula( alunos.getMatricula() );
        alunosEntity.status( alunos.getStatus() );
        alunosEntity.telefonePessoal( alunos.getTelefonePessoal() );
        alunosEntity.telefoneProfissional( alunos.getTelefoneProfissional() );
        alunosEntity.usuarios( usuariosToUsuariosEntity( alunos.getUsuarios() ) );
        alunosEntity.uuid( alunos.getUuid() );

        return alunosEntity.build();
    }

    protected UnidadeCurricularEntity unidadeCurricularToUnidadeCurricularEntity(UnidadeCurricular unidadeCurricular) {
        if ( unidadeCurricular == null ) {
            return null;
        }

        UnidadeCurricularEntity.UnidadeCurricularEntityBuilder unidadeCurricularEntity = UnidadeCurricularEntity.builder();

        unidadeCurricularEntity.atualizadoEm( unidadeCurricular.getAtualizadoEm() );
        unidadeCurricularEntity.cargaHoraria( unidadeCurricular.getCargaHoraria() );
        unidadeCurricularEntity.criadoEm( unidadeCurricular.getCriadoEm() );
        unidadeCurricularEntity.descricao( unidadeCurricular.getDescricao() );
        unidadeCurricularEntity.nome( unidadeCurricular.getNome() );
        unidadeCurricularEntity.uuid( unidadeCurricular.getUuid() );

        return unidadeCurricularEntity.build();
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

    protected Alunos alunosEntityToAlunos(AlunosEntity alunosEntity) {
        if ( alunosEntity == null ) {
            return null;
        }

        Alunos.AlunosBuilder alunos = Alunos.builder();

        alunos.atualizadoEm( alunosEntity.getAtualizadoEm() );
        alunos.criadoEm( alunosEntity.getCriadoEm() );
        alunos.curso( alunosEntity.getCurso() );
        alunos.endereco( enderecoEntityToEndereco( alunosEntity.getEndereco() ) );
        alunos.linkedin( alunosEntity.getLinkedin() );
        alunos.matricula( alunosEntity.getMatricula() );
        alunos.status( alunosEntity.getStatus() );
        alunos.telefonePessoal( alunosEntity.getTelefonePessoal() );
        alunos.telefoneProfissional( alunosEntity.getTelefoneProfissional() );
        alunos.usuarios( usuariosEntityToUsuarios( alunosEntity.getUsuarios() ) );
        alunos.uuid( alunosEntity.getUuid() );

        return alunos.build();
    }

    protected UnidadeCurricular unidadeCurricularEntityToUnidadeCurricular(UnidadeCurricularEntity unidadeCurricularEntity) {
        if ( unidadeCurricularEntity == null ) {
            return null;
        }

        UnidadeCurricular.UnidadeCurricularBuilder unidadeCurricular = UnidadeCurricular.builder();

        unidadeCurricular.atualizadoEm( unidadeCurricularEntity.getAtualizadoEm() );
        unidadeCurricular.cargaHoraria( unidadeCurricularEntity.getCargaHoraria() );
        unidadeCurricular.criadoEm( unidadeCurricularEntity.getCriadoEm() );
        unidadeCurricular.descricao( unidadeCurricularEntity.getDescricao() );
        unidadeCurricular.nome( unidadeCurricularEntity.getNome() );
        unidadeCurricular.uuid( unidadeCurricularEntity.getUuid() );

        return unidadeCurricular.build();
    }
}
