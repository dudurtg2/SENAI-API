package com.exemplo.meuapp.common.mapper;

import com.exemplo.meuapp.domain.model.Alunos;
import com.exemplo.meuapp.domain.model.Disciplina;
import com.exemplo.meuapp.domain.model.DisciplinaProjeto;
import com.exemplo.meuapp.domain.model.Endereco;
import com.exemplo.meuapp.domain.model.Professores;
import com.exemplo.meuapp.domain.model.Projeto;
import com.exemplo.meuapp.domain.model.UnidadeCurricular;
import com.exemplo.meuapp.infrastructure.persistence.entity.AlunosEntity;
import com.exemplo.meuapp.infrastructure.persistence.entity.DisciplinaEntity;
import com.exemplo.meuapp.infrastructure.persistence.entity.DisciplinaProjetoEntity;
import com.exemplo.meuapp.infrastructure.persistence.entity.EnderecoEntity;
import com.exemplo.meuapp.infrastructure.persistence.entity.ProfessoresEntity;
import com.exemplo.meuapp.infrastructure.persistence.entity.ProjetoEntity;
import com.exemplo.meuapp.infrastructure.persistence.entity.UnidadeCurricularEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-27T00:56:32-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 22.0.2 (Oracle Corporation)"
)
@Component
public class DisciplinaProjetoMapperImpl implements DisciplinaProjetoMapper {

    @Override
    public DisciplinaProjetoEntity toEntity(DisciplinaProjeto aluno) {
        if ( aluno == null ) {
            return null;
        }

        DisciplinaProjetoEntity.DisciplinaProjetoEntityBuilder disciplinaProjetoEntity = DisciplinaProjetoEntity.builder();

        disciplinaProjetoEntity.uuid( aluno.getUuid() );
        disciplinaProjetoEntity.disciplina( disciplinaToDisciplinaEntity( aluno.getDisciplina() ) );
        disciplinaProjetoEntity.projeto( projetoToProjetoEntity( aluno.getProjeto() ) );

        return disciplinaProjetoEntity.build();
    }

    @Override
    public DisciplinaProjeto toDomain(DisciplinaProjetoEntity alunoEntity) {
        if ( alunoEntity == null ) {
            return null;
        }

        DisciplinaProjeto.DisciplinaProjetoBuilder disciplinaProjeto = DisciplinaProjeto.builder();

        disciplinaProjeto.uuid( alunoEntity.getUuid() );
        disciplinaProjeto.disciplina( disciplinaEntityToDisciplina( alunoEntity.getDisciplina() ) );
        disciplinaProjeto.projeto( projetoEntityToProjeto( alunoEntity.getProjeto() ) );

        return disciplinaProjeto.build();
    }

    @Override
    public List<DisciplinaProjeto> toDomain(List<DisciplinaProjetoEntity> DisciplinaProjetoEntities) {
        if ( DisciplinaProjetoEntities == null ) {
            return null;
        }

        List<DisciplinaProjeto> list = new ArrayList<DisciplinaProjeto>( DisciplinaProjetoEntities.size() );
        for ( DisciplinaProjetoEntity disciplinaProjetoEntity : DisciplinaProjetoEntities ) {
            list.add( toDomain( disciplinaProjetoEntity ) );
        }

        return list;
    }

    @Override
    public List<DisciplinaProjetoEntity> toEntity(List<DisciplinaProjeto> DisciplinaProjeto) {
        if ( DisciplinaProjeto == null ) {
            return null;
        }

        List<DisciplinaProjetoEntity> list = new ArrayList<DisciplinaProjetoEntity>( DisciplinaProjeto.size() );
        for ( DisciplinaProjeto disciplinaProjeto : DisciplinaProjeto ) {
            list.add( toEntity( disciplinaProjeto ) );
        }

        return list;
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

    protected ProfessoresEntity professoresToProfessoresEntity(Professores professores) {
        if ( professores == null ) {
            return null;
        }

        ProfessoresEntity.ProfessoresEntityBuilder professoresEntity = ProfessoresEntity.builder();

        professoresEntity.uuid( professores.getUuid() );
        professoresEntity.especialidade( professores.getEspecialidade() );
        professoresEntity.departamento( professores.getDepartamento() );
        professoresEntity.telefonePessoal( professores.getTelefonePessoal() );
        professoresEntity.telefoneProfissional( professores.getTelefoneProfissional() );
        professoresEntity.linkedin( professores.getLinkedin() );
        professoresEntity.endereco( enderecoToEnderecoEntity( professores.getEndereco() ) );
        professoresEntity.status( professores.getStatus() );
        professoresEntity.criadoEm( professores.getCriadoEm() );
        professoresEntity.atualizadoEm( professores.getAtualizadoEm() );

        return professoresEntity.build();
    }

    protected DisciplinaEntity disciplinaToDisciplinaEntity(Disciplina disciplina) {
        if ( disciplina == null ) {
            return null;
        }

        DisciplinaEntity.DisciplinaEntityBuilder disciplinaEntity = DisciplinaEntity.builder();

        disciplinaEntity.uuid( disciplina.getUuid() );
        disciplinaEntity.nome( disciplina.getNome() );
        disciplinaEntity.professor( professoresToProfessoresEntity( disciplina.getProfessor() ) );
        disciplinaEntity.criadoEm( disciplina.getCriadoEm() );
        disciplinaEntity.atualizadoEm( disciplina.getAtualizadoEm() );

        return disciplinaEntity.build();
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

    protected Professores professoresEntityToProfessores(ProfessoresEntity professoresEntity) {
        if ( professoresEntity == null ) {
            return null;
        }

        Professores.ProfessoresBuilder professores = Professores.builder();

        professores.uuid( professoresEntity.getUuid() );
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

    protected Disciplina disciplinaEntityToDisciplina(DisciplinaEntity disciplinaEntity) {
        if ( disciplinaEntity == null ) {
            return null;
        }

        Disciplina.DisciplinaBuilder disciplina = Disciplina.builder();

        disciplina.uuid( disciplinaEntity.getUuid() );
        disciplina.nome( disciplinaEntity.getNome() );
        disciplina.professor( professoresEntityToProfessores( disciplinaEntity.getProfessor() ) );
        disciplina.criadoEm( disciplinaEntity.getCriadoEm() );
        disciplina.atualizadoEm( disciplinaEntity.getAtualizadoEm() );

        return disciplina.build();
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
