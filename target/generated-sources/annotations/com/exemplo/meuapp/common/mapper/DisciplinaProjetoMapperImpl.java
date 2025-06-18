package com.exemplo.meuapp.common.mapper;

import com.exemplo.meuapp.domain.model.Alunos;
import com.exemplo.meuapp.domain.model.Disciplina;
import com.exemplo.meuapp.domain.model.DisciplinaProjeto;
import com.exemplo.meuapp.domain.model.Endereco;
import com.exemplo.meuapp.domain.model.Professores;
import com.exemplo.meuapp.domain.model.Projeto;
import com.exemplo.meuapp.domain.model.UnidadeCurricular;
import com.exemplo.meuapp.domain.model.Usuarios;
import com.exemplo.meuapp.infrastructure.persistence.entity.AlunosEntity;
import com.exemplo.meuapp.infrastructure.persistence.entity.DisciplinaEntity;
import com.exemplo.meuapp.infrastructure.persistence.entity.DisciplinaProjetoEntity;
import com.exemplo.meuapp.infrastructure.persistence.entity.EnderecoEntity;
import com.exemplo.meuapp.infrastructure.persistence.entity.ProfessoresEntity;
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
public class DisciplinaProjetoMapperImpl implements DisciplinaProjetoMapper {

    @Override
    public DisciplinaProjetoEntity toEntity(DisciplinaProjeto aluno) {
        if ( aluno == null ) {
            return null;
        }

        DisciplinaProjetoEntity.DisciplinaProjetoEntityBuilder disciplinaProjetoEntity = DisciplinaProjetoEntity.builder();

        disciplinaProjetoEntity.disciplina( disciplinaToDisciplinaEntity( aluno.getDisciplina() ) );
        disciplinaProjetoEntity.projeto( projetoToProjetoEntity( aluno.getProjeto() ) );
        disciplinaProjetoEntity.uuid( aluno.getUuid() );

        return disciplinaProjetoEntity.build();
    }

    @Override
    public DisciplinaProjeto toDomain(DisciplinaProjetoEntity alunoEntity) {
        if ( alunoEntity == null ) {
            return null;
        }

        DisciplinaProjeto.DisciplinaProjetoBuilder disciplinaProjeto = DisciplinaProjeto.builder();

        disciplinaProjeto.disciplina( disciplinaEntityToDisciplina( alunoEntity.getDisciplina() ) );
        disciplinaProjeto.projeto( projetoEntityToProjeto( alunoEntity.getProjeto() ) );
        disciplinaProjeto.uuid( alunoEntity.getUuid() );

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

    protected ProfessoresEntity professoresToProfessoresEntity(Professores professores) {
        if ( professores == null ) {
            return null;
        }

        ProfessoresEntity.ProfessoresEntityBuilder professoresEntity = ProfessoresEntity.builder();

        professoresEntity.atualizadoEm( professores.getAtualizadoEm() );
        professoresEntity.criadoEm( professores.getCriadoEm() );
        professoresEntity.departamento( professores.getDepartamento() );
        professoresEntity.endereco( enderecoToEnderecoEntity( professores.getEndereco() ) );
        professoresEntity.especialidade( professores.getEspecialidade() );
        professoresEntity.linkedin( professores.getLinkedin() );
        professoresEntity.status( professores.getStatus() );
        professoresEntity.telefonePessoal( professores.getTelefonePessoal() );
        professoresEntity.telefoneProfissional( professores.getTelefoneProfissional() );
        professoresEntity.usuarios( usuariosToUsuariosEntity( professores.getUsuarios() ) );
        professoresEntity.uuid( professores.getUuid() );

        return professoresEntity.build();
    }

    protected DisciplinaEntity disciplinaToDisciplinaEntity(Disciplina disciplina) {
        if ( disciplina == null ) {
            return null;
        }

        DisciplinaEntity.DisciplinaEntityBuilder disciplinaEntity = DisciplinaEntity.builder();

        disciplinaEntity.atualizadoEm( disciplina.getAtualizadoEm() );
        disciplinaEntity.criadoEm( disciplina.getCriadoEm() );
        disciplinaEntity.nome( disciplina.getNome() );
        disciplinaEntity.professor( professoresToProfessoresEntity( disciplina.getProfessor() ) );
        disciplinaEntity.uuid( disciplina.getUuid() );

        return disciplinaEntity.build();
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

    protected Professores professoresEntityToProfessores(ProfessoresEntity professoresEntity) {
        if ( professoresEntity == null ) {
            return null;
        }

        Professores.ProfessoresBuilder professores = Professores.builder();

        professores.atualizadoEm( professoresEntity.getAtualizadoEm() );
        professores.criadoEm( professoresEntity.getCriadoEm() );
        professores.departamento( professoresEntity.getDepartamento() );
        professores.endereco( enderecoEntityToEndereco( professoresEntity.getEndereco() ) );
        professores.especialidade( professoresEntity.getEspecialidade() );
        professores.linkedin( professoresEntity.getLinkedin() );
        professores.status( professoresEntity.getStatus() );
        professores.telefonePessoal( professoresEntity.getTelefonePessoal() );
        professores.telefoneProfissional( professoresEntity.getTelefoneProfissional() );
        professores.usuarios( usuariosEntityToUsuarios( professoresEntity.getUsuarios() ) );
        professores.uuid( professoresEntity.getUuid() );

        return professores.build();
    }

    protected Disciplina disciplinaEntityToDisciplina(DisciplinaEntity disciplinaEntity) {
        if ( disciplinaEntity == null ) {
            return null;
        }

        Disciplina.DisciplinaBuilder disciplina = Disciplina.builder();

        disciplina.atualizadoEm( disciplinaEntity.getAtualizadoEm() );
        disciplina.criadoEm( disciplinaEntity.getCriadoEm() );
        disciplina.nome( disciplinaEntity.getNome() );
        disciplina.professor( professoresEntityToProfessores( disciplinaEntity.getProfessor() ) );
        disciplina.uuid( disciplinaEntity.getUuid() );

        return disciplina.build();
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
}
