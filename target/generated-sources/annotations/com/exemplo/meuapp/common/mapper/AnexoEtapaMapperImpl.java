package com.exemplo.meuapp.common.mapper;

import com.exemplo.meuapp.domain.model.Alunos;
import com.exemplo.meuapp.domain.model.AnexoEtapa;
import com.exemplo.meuapp.domain.model.Endereco;
import com.exemplo.meuapp.domain.model.EtapasProjeto;
import com.exemplo.meuapp.domain.model.Projeto;
import com.exemplo.meuapp.domain.model.UnidadeCurricular;
import com.exemplo.meuapp.domain.model.Usuarios;
import com.exemplo.meuapp.infrastructure.persistence.entity.AlunosEntity;
import com.exemplo.meuapp.infrastructure.persistence.entity.AnexoEtapaEntity;
import com.exemplo.meuapp.infrastructure.persistence.entity.EnderecoEntity;
import com.exemplo.meuapp.infrastructure.persistence.entity.EtapasProjetoEntity;
import com.exemplo.meuapp.infrastructure.persistence.entity.ProjetoEntity;
import com.exemplo.meuapp.infrastructure.persistence.entity.UnidadeCurricularEntity;
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
public class AnexoEtapaMapperImpl implements AnexoEtapaMapper {

    @Override
    public AnexoEtapaEntity toEntity(AnexoEtapa aluno) {
        if ( aluno == null ) {
            return null;
        }

        AnexoEtapaEntity.AnexoEtapaEntityBuilder anexoEtapaEntity = AnexoEtapaEntity.builder();

        anexoEtapaEntity.dataUpload( aluno.getDataUpload() );
        anexoEtapaEntity.etapa( etapasProjetoToEtapasProjetoEntity( aluno.getEtapa() ) );
        anexoEtapaEntity.nomeArquivo( aluno.getNomeArquivo() );
        anexoEtapaEntity.tipo( aluno.getTipo() );
        anexoEtapaEntity.url( aluno.getUrl() );
        anexoEtapaEntity.uuid( aluno.getUuid() );

        return anexoEtapaEntity.build();
    }

    @Override
    public AnexoEtapa toDomain(AnexoEtapaEntity alunoEntity) {
        if ( alunoEntity == null ) {
            return null;
        }

        AnexoEtapa.AnexoEtapaBuilder anexoEtapa = AnexoEtapa.builder();

        anexoEtapa.dataUpload( alunoEntity.getDataUpload() );
        anexoEtapa.etapa( etapasProjetoEntityToEtapasProjeto( alunoEntity.getEtapa() ) );
        anexoEtapa.nomeArquivo( alunoEntity.getNomeArquivo() );
        anexoEtapa.tipo( alunoEntity.getTipo() );
        anexoEtapa.url( alunoEntity.getUrl() );
        anexoEtapa.uuid( alunoEntity.getUuid() );

        return anexoEtapa.build();
    }

    @Override
    public List<AnexoEtapa> toDomain(List<AnexoEtapaEntity> AnexoEtapaEntities) {
        if ( AnexoEtapaEntities == null ) {
            return null;
        }

        List<AnexoEtapa> list = new ArrayList<AnexoEtapa>( AnexoEtapaEntities.size() );
        for ( AnexoEtapaEntity anexoEtapaEntity : AnexoEtapaEntities ) {
            list.add( toDomain( anexoEtapaEntity ) );
        }

        return list;
    }

    @Override
    public List<AnexoEtapaEntity> toEntity(List<AnexoEtapa> AnexoEtapa) {
        if ( AnexoEtapa == null ) {
            return null;
        }

        List<AnexoEtapaEntity> list = new ArrayList<AnexoEtapaEntity>( AnexoEtapa.size() );
        for ( AnexoEtapa anexoEtapa : AnexoEtapa ) {
            list.add( toEntity( anexoEtapa ) );
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

    protected ProjetoEntity projetoToProjetoEntity(Projeto projeto) {
        if ( projeto == null ) {
            return null;
        }

        ProjetoEntity.ProjetoEntityBuilder projetoEntity = ProjetoEntity.builder();

        projetoEntity.atualizadoEm( projeto.getAtualizadoEm() );
        projetoEntity.bannerUrl( projeto.getBannerUrl() );
        projetoEntity.codigo( projeto.getCodigo() );
        projetoEntity.criadoEm( projeto.getCriadoEm() );
        projetoEntity.curso( projeto.getCurso() );
        projetoEntity.descricao( projeto.getDescricao() );
        projetoEntity.itinerario( projeto.isItinerario() );
        projetoEntity.labMaker( projeto.isLabMaker() );
        projetoEntity.liderProjeto( alunosToAlunosEntity( projeto.getLiderProjeto() ) );
        projetoEntity.participouSaga( projeto.isParticipouSaga() );
        projetoEntity.status( projeto.getStatus() );
        projetoEntity.titulo( projeto.getTitulo() );
        projetoEntity.turma( projeto.getTurma() );
        projetoEntity.unidadeCurricular( unidadeCurricularToUnidadeCurricularEntity( projeto.getUnidadeCurricular() ) );
        projetoEntity.uuid( projeto.getUuid() );
        projetoEntity.visibilidadeAnexos( projeto.getVisibilidadeAnexos() );
        projetoEntity.visibilidadeCodigo( projeto.getVisibilidadeCodigo() );

        return projetoEntity.build();
    }

    protected EtapasProjetoEntity etapasProjetoToEtapasProjetoEntity(EtapasProjeto etapasProjeto) {
        if ( etapasProjeto == null ) {
            return null;
        }

        EtapasProjetoEntity.EtapasProjetoEntityBuilder etapasProjetoEntity = EtapasProjetoEntity.builder();

        etapasProjetoEntity.atualizadoEm( etapasProjeto.getAtualizadoEm() );
        etapasProjetoEntity.criadoEm( etapasProjeto.getCriadoEm() );
        etapasProjetoEntity.descricao( etapasProjeto.getDescricao() );
        etapasProjetoEntity.nomeEtapa( etapasProjeto.getNomeEtapa() );
        etapasProjetoEntity.ordem( etapasProjeto.getOrdem() );
        etapasProjetoEntity.projeto( projetoToProjetoEntity( etapasProjeto.getProjeto() ) );
        etapasProjetoEntity.status( etapasProjeto.getStatus() );
        etapasProjetoEntity.uuid( etapasProjeto.getUuid() );

        return etapasProjetoEntity.build();
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

    protected Projeto projetoEntityToProjeto(ProjetoEntity projetoEntity) {
        if ( projetoEntity == null ) {
            return null;
        }

        Projeto.ProjetoBuilder projeto = Projeto.builder();

        projeto.atualizadoEm( projetoEntity.getAtualizadoEm() );
        projeto.bannerUrl( projetoEntity.getBannerUrl() );
        projeto.codigo( projetoEntity.getCodigo() );
        projeto.criadoEm( projetoEntity.getCriadoEm() );
        projeto.curso( projetoEntity.getCurso() );
        projeto.descricao( projetoEntity.getDescricao() );
        projeto.itinerario( projetoEntity.isItinerario() );
        projeto.labMaker( projetoEntity.isLabMaker() );
        projeto.liderProjeto( alunosEntityToAlunos( projetoEntity.getLiderProjeto() ) );
        projeto.participouSaga( projetoEntity.isParticipouSaga() );
        projeto.status( projetoEntity.getStatus() );
        projeto.titulo( projetoEntity.getTitulo() );
        projeto.turma( projetoEntity.getTurma() );
        projeto.unidadeCurricular( unidadeCurricularEntityToUnidadeCurricular( projetoEntity.getUnidadeCurricular() ) );
        projeto.uuid( projetoEntity.getUuid() );
        projeto.visibilidadeAnexos( projetoEntity.getVisibilidadeAnexos() );
        projeto.visibilidadeCodigo( projetoEntity.getVisibilidadeCodigo() );

        return projeto.build();
    }

    protected EtapasProjeto etapasProjetoEntityToEtapasProjeto(EtapasProjetoEntity etapasProjetoEntity) {
        if ( etapasProjetoEntity == null ) {
            return null;
        }

        EtapasProjeto.EtapasProjetoBuilder etapasProjeto = EtapasProjeto.builder();

        etapasProjeto.atualizadoEm( etapasProjetoEntity.getAtualizadoEm() );
        etapasProjeto.criadoEm( etapasProjetoEntity.getCriadoEm() );
        etapasProjeto.descricao( etapasProjetoEntity.getDescricao() );
        etapasProjeto.nomeEtapa( etapasProjetoEntity.getNomeEtapa() );
        etapasProjeto.ordem( etapasProjetoEntity.getOrdem() );
        etapasProjeto.projeto( projetoEntityToProjeto( etapasProjetoEntity.getProjeto() ) );
        etapasProjeto.status( etapasProjetoEntity.getStatus() );
        etapasProjeto.uuid( etapasProjetoEntity.getUuid() );

        return etapasProjeto.build();
    }
}
