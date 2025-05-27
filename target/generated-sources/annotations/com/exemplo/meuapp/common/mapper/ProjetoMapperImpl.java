package com.exemplo.meuapp.common.mapper;

import com.exemplo.meuapp.domain.model.Alunos;
import com.exemplo.meuapp.domain.model.Endereco;
import com.exemplo.meuapp.domain.model.Projeto;
import com.exemplo.meuapp.domain.model.UnidadeCurricular;
import com.exemplo.meuapp.infrastructure.persistence.entity.AlunosEntity;
import com.exemplo.meuapp.infrastructure.persistence.entity.EnderecoEntity;
import com.exemplo.meuapp.infrastructure.persistence.entity.ProjetoEntity;
import com.exemplo.meuapp.infrastructure.persistence.entity.UnidadeCurricularEntity;
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
public class ProjetoMapperImpl implements ProjetoMapper {

    @Override
    public ProjetoEntity toEntity(Projeto aluno) {
        if ( aluno == null ) {
            return null;
        }

        ProjetoEntity.ProjetoEntityBuilder projetoEntity = ProjetoEntity.builder();

        projetoEntity.uuid( aluno.getUuid() );
        projetoEntity.titulo( aluno.getTitulo() );
        projetoEntity.descricao( aluno.getDescricao() );
        projetoEntity.curso( aluno.getCurso() );
        projetoEntity.turma( aluno.getTurma() );
        projetoEntity.labMaker( aluno.isLabMaker() );
        projetoEntity.participouSaga( aluno.isParticipouSaga() );
        projetoEntity.itinerario( aluno.isItinerario() );
        projetoEntity.unidadeCurricular( unidadeCurricularToUnidadeCurricularEntity( aluno.getUnidadeCurricular() ) );
        projetoEntity.liderProjeto( alunosToAlunosEntity( aluno.getLiderProjeto() ) );
        projetoEntity.bannerUrl( aluno.getBannerUrl() );
        projetoEntity.codigo( aluno.getCodigo() );
        projetoEntity.visibilidadeCodigo( aluno.getVisibilidadeCodigo() );
        projetoEntity.visibilidadeAnexos( aluno.getVisibilidadeAnexos() );
        projetoEntity.status( aluno.getStatus() );
        projetoEntity.criadoEm( aluno.getCriadoEm() );
        projetoEntity.atualizadoEm( aluno.getAtualizadoEm() );

        return projetoEntity.build();
    }

    @Override
    public Projeto toDomain(ProjetoEntity alunoEntity) {
        if ( alunoEntity == null ) {
            return null;
        }

        Projeto.ProjetoBuilder projeto = Projeto.builder();

        projeto.uuid( alunoEntity.getUuid() );
        projeto.titulo( alunoEntity.getTitulo() );
        projeto.descricao( alunoEntity.getDescricao() );
        projeto.curso( alunoEntity.getCurso() );
        projeto.turma( alunoEntity.getTurma() );
        projeto.labMaker( alunoEntity.isLabMaker() );
        projeto.participouSaga( alunoEntity.isParticipouSaga() );
        projeto.itinerario( alunoEntity.isItinerario() );
        projeto.unidadeCurricular( unidadeCurricularEntityToUnidadeCurricular( alunoEntity.getUnidadeCurricular() ) );
        projeto.liderProjeto( alunosEntityToAlunos( alunoEntity.getLiderProjeto() ) );
        projeto.bannerUrl( alunoEntity.getBannerUrl() );
        projeto.codigo( alunoEntity.getCodigo() );
        projeto.visibilidadeCodigo( alunoEntity.getVisibilidadeCodigo() );
        projeto.visibilidadeAnexos( alunoEntity.getVisibilidadeAnexos() );
        projeto.status( alunoEntity.getStatus() );
        projeto.criadoEm( alunoEntity.getCriadoEm() );
        projeto.atualizadoEm( alunoEntity.getAtualizadoEm() );

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

    protected UnidadeCurricularEntity unidadeCurricularToUnidadeCurricularEntity(UnidadeCurricular unidadeCurricular) {
        if ( unidadeCurricular == null ) {
            return null;
        }

        UnidadeCurricularEntity.UnidadeCurricularEntityBuilder unidadeCurricularEntity = UnidadeCurricularEntity.builder();

        unidadeCurricularEntity.uuid( unidadeCurricular.getUuid() );
        unidadeCurricularEntity.nome( unidadeCurricular.getNome() );
        unidadeCurricularEntity.descricao( unidadeCurricular.getDescricao() );
        unidadeCurricularEntity.cargaHoraria( unidadeCurricular.getCargaHoraria() );
        unidadeCurricularEntity.criadoEm( unidadeCurricular.getCriadoEm() );
        unidadeCurricularEntity.atualizadoEm( unidadeCurricular.getAtualizadoEm() );

        return unidadeCurricularEntity.build();
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

    protected AlunosEntity alunosToAlunosEntity(Alunos alunos) {
        if ( alunos == null ) {
            return null;
        }

        AlunosEntity.AlunosEntityBuilder alunosEntity = AlunosEntity.builder();

        alunosEntity.uuid( alunos.getUuid() );
        alunosEntity.matricula( alunos.getMatricula() );
        alunosEntity.curso( alunos.getCurso() );
        alunosEntity.telefonePessoal( alunos.getTelefonePessoal() );
        alunosEntity.telefoneProfissional( alunos.getTelefoneProfissional() );
        alunosEntity.linkedin( alunos.getLinkedin() );
        alunosEntity.endereco( enderecoToEnderecoEntity( alunos.getEndereco() ) );
        alunosEntity.status( alunos.getStatus() );
        alunosEntity.criadoEm( alunos.getCriadoEm() );
        alunosEntity.atualizadoEm( alunos.getAtualizadoEm() );

        return alunosEntity.build();
    }

    protected UnidadeCurricular unidadeCurricularEntityToUnidadeCurricular(UnidadeCurricularEntity unidadeCurricularEntity) {
        if ( unidadeCurricularEntity == null ) {
            return null;
        }

        UnidadeCurricular.UnidadeCurricularBuilder unidadeCurricular = UnidadeCurricular.builder();

        unidadeCurricular.uuid( unidadeCurricularEntity.getUuid() );
        unidadeCurricular.nome( unidadeCurricularEntity.getNome() );
        unidadeCurricular.descricao( unidadeCurricularEntity.getDescricao() );
        unidadeCurricular.cargaHoraria( unidadeCurricularEntity.getCargaHoraria() );
        unidadeCurricular.criadoEm( unidadeCurricularEntity.getCriadoEm() );
        unidadeCurricular.atualizadoEm( unidadeCurricularEntity.getAtualizadoEm() );

        return unidadeCurricular.build();
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

    protected Alunos alunosEntityToAlunos(AlunosEntity alunosEntity) {
        if ( alunosEntity == null ) {
            return null;
        }

        Alunos.AlunosBuilder alunos = Alunos.builder();

        alunos.uuid( alunosEntity.getUuid() );
        alunos.matricula( alunosEntity.getMatricula() );
        alunos.curso( alunosEntity.getCurso() );
        alunos.telefonePessoal( alunosEntity.getTelefonePessoal() );
        alunos.telefoneProfissional( alunosEntity.getTelefoneProfissional() );
        alunos.linkedin( alunosEntity.getLinkedin() );
        alunos.endereco( enderecoEntityToEndereco( alunosEntity.getEndereco() ) );
        alunos.status( alunosEntity.getStatus() );
        alunos.criadoEm( alunosEntity.getCriadoEm() );
        alunos.atualizadoEm( alunosEntity.getAtualizadoEm() );

        return alunos.build();
    }
}
