package com.exemplo.meuapp.common.mapper;

import com.exemplo.meuapp.domain.model.Alunos;
import com.exemplo.meuapp.domain.model.Endereco;
import com.exemplo.meuapp.domain.model.Projeto;
import com.exemplo.meuapp.domain.model.ProjetoAluno;
import com.exemplo.meuapp.domain.model.UnidadeCurricular;
import com.exemplo.meuapp.infrastructure.persistence.entity.AlunosEntity;
import com.exemplo.meuapp.infrastructure.persistence.entity.EnderecoEntity;
import com.exemplo.meuapp.infrastructure.persistence.entity.ProjetoAlunoEntity;
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
public class ProjetoAlunoMapperImpl implements ProjetoAlunoMapper {

    @Override
    public ProjetoAlunoEntity toEntity(ProjetoAluno aluno) {
        if ( aluno == null ) {
            return null;
        }

        ProjetoAlunoEntity.ProjetoAlunoEntityBuilder projetoAlunoEntity = ProjetoAlunoEntity.builder();

        projetoAlunoEntity.uuid( aluno.getUuid() );
        projetoAlunoEntity.projeto( projetoToProjetoEntity( aluno.getProjeto() ) );
        projetoAlunoEntity.aluno( alunosToAlunosEntity( aluno.getAluno() ) );

        return projetoAlunoEntity.build();
    }

    @Override
    public ProjetoAluno toDomain(ProjetoAlunoEntity alunoEntity) {
        if ( alunoEntity == null ) {
            return null;
        }

        ProjetoAluno.ProjetoAlunoBuilder projetoAluno = ProjetoAluno.builder();

        projetoAluno.uuid( alunoEntity.getUuid() );
        projetoAluno.projeto( projetoEntityToProjeto( alunoEntity.getProjeto() ) );
        projetoAluno.aluno( alunosEntityToAlunos( alunoEntity.getAluno() ) );

        return projetoAluno.build();
    }

    @Override
    public List<ProjetoAluno> toDomain(List<ProjetoAlunoEntity> ProjetoAlunoEntities) {
        if ( ProjetoAlunoEntities == null ) {
            return null;
        }

        List<ProjetoAluno> list = new ArrayList<ProjetoAluno>( ProjetoAlunoEntities.size() );
        for ( ProjetoAlunoEntity projetoAlunoEntity : ProjetoAlunoEntities ) {
            list.add( toDomain( projetoAlunoEntity ) );
        }

        return list;
    }

    @Override
    public List<ProjetoAlunoEntity> toEntity(List<ProjetoAluno> ProjetoAluno) {
        if ( ProjetoAluno == null ) {
            return null;
        }

        List<ProjetoAlunoEntity> list = new ArrayList<ProjetoAlunoEntity>( ProjetoAluno.size() );
        for ( ProjetoAluno projetoAluno : ProjetoAluno ) {
            list.add( toEntity( projetoAluno ) );
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

    protected ProjetoEntity projetoToProjetoEntity(Projeto projeto) {
        if ( projeto == null ) {
            return null;
        }

        ProjetoEntity.ProjetoEntityBuilder projetoEntity = ProjetoEntity.builder();

        projetoEntity.uuid( projeto.getUuid() );
        projetoEntity.titulo( projeto.getTitulo() );
        projetoEntity.descricao( projeto.getDescricao() );
        projetoEntity.curso( projeto.getCurso() );
        projetoEntity.turma( projeto.getTurma() );
        projetoEntity.labMaker( projeto.isLabMaker() );
        projetoEntity.participouSaga( projeto.isParticipouSaga() );
        projetoEntity.itinerario( projeto.isItinerario() );
        projetoEntity.unidadeCurricular( unidadeCurricularToUnidadeCurricularEntity( projeto.getUnidadeCurricular() ) );
        projetoEntity.liderProjeto( alunosToAlunosEntity( projeto.getLiderProjeto() ) );
        projetoEntity.bannerUrl( projeto.getBannerUrl() );
        projetoEntity.codigo( projeto.getCodigo() );
        projetoEntity.visibilidadeCodigo( projeto.getVisibilidadeCodigo() );
        projetoEntity.visibilidadeAnexos( projeto.getVisibilidadeAnexos() );
        projetoEntity.status( projeto.getStatus() );
        projetoEntity.criadoEm( projeto.getCriadoEm() );
        projetoEntity.atualizadoEm( projeto.getAtualizadoEm() );

        return projetoEntity.build();
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

    protected Projeto projetoEntityToProjeto(ProjetoEntity projetoEntity) {
        if ( projetoEntity == null ) {
            return null;
        }

        Projeto.ProjetoBuilder projeto = Projeto.builder();

        projeto.uuid( projetoEntity.getUuid() );
        projeto.titulo( projetoEntity.getTitulo() );
        projeto.descricao( projetoEntity.getDescricao() );
        projeto.curso( projetoEntity.getCurso() );
        projeto.turma( projetoEntity.getTurma() );
        projeto.labMaker( projetoEntity.isLabMaker() );
        projeto.participouSaga( projetoEntity.isParticipouSaga() );
        projeto.itinerario( projetoEntity.isItinerario() );
        projeto.unidadeCurricular( unidadeCurricularEntityToUnidadeCurricular( projetoEntity.getUnidadeCurricular() ) );
        projeto.liderProjeto( alunosEntityToAlunos( projetoEntity.getLiderProjeto() ) );
        projeto.bannerUrl( projetoEntity.getBannerUrl() );
        projeto.codigo( projetoEntity.getCodigo() );
        projeto.visibilidadeCodigo( projetoEntity.getVisibilidadeCodigo() );
        projeto.visibilidadeAnexos( projetoEntity.getVisibilidadeAnexos() );
        projeto.status( projetoEntity.getStatus() );
        projeto.criadoEm( projetoEntity.getCriadoEm() );
        projeto.atualizadoEm( projetoEntity.getAtualizadoEm() );

        return projeto.build();
    }
}
