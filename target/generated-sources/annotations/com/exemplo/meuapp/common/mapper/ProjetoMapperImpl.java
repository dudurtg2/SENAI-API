package com.exemplo.meuapp.common.mapper;

import com.exemplo.meuapp.domain.model.Alunos;
import com.exemplo.meuapp.domain.model.Anexo;
import com.exemplo.meuapp.domain.model.Curso;
import com.exemplo.meuapp.domain.model.Disciplina;
import com.exemplo.meuapp.domain.model.Endereco;
import com.exemplo.meuapp.domain.model.Professores;
import com.exemplo.meuapp.domain.model.Projeto;
import com.exemplo.meuapp.domain.model.Usuarios;
import com.exemplo.meuapp.infrastructure.persistence.entity.AlunosEntity;
import com.exemplo.meuapp.infrastructure.persistence.entity.AnexoEntity;
import com.exemplo.meuapp.infrastructure.persistence.entity.CursoEntity;
import com.exemplo.meuapp.infrastructure.persistence.entity.DisciplinaEntity;
import com.exemplo.meuapp.infrastructure.persistence.entity.EnderecoEntity;
import com.exemplo.meuapp.infrastructure.persistence.entity.ProfessoresEntity;
import com.exemplo.meuapp.infrastructure.persistence.entity.ProjetoEntity;
import com.exemplo.meuapp.infrastructure.persistence.entity.UsuariosEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-18T14:11:44-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 21.0.5 (Oracle Corporation)"
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
        projetoEntity.turma( aluno.getTurma() );
        projetoEntity.labMaker( aluno.isLabMaker() );
        projetoEntity.participouSaga( aluno.isParticipouSaga() );
        projetoEntity.itinerario( aluno.isItinerario() );
        projetoEntity.disciplina( disciplinaToDisciplinaEntity( aluno.getDisciplina() ) );
        projetoEntity.anexos( anexoListToAnexoEntityList( aluno.getAnexos() ) );
        projetoEntity.lider( alunosToAlunosEntity( aluno.getLider() ) );
        projetoEntity.bannerUrl( aluno.getBannerUrl() );
        projetoEntity.codigo( aluno.getCodigo() );
        projetoEntity.visibilidade( aluno.getVisibilidade() );
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
        projeto.turma( alunoEntity.getTurma() );
        projeto.bannerUrl( alunoEntity.getBannerUrl() );
        projeto.codigo( alunoEntity.getCodigo() );
        projeto.anexos( anexoEntityListToAnexoList( alunoEntity.getAnexos() ) );
        projeto.disciplina( disciplinaEntityToDisciplina( alunoEntity.getDisciplina() ) );
        projeto.lider( alunosEntityToAlunos( alunoEntity.getLider() ) );
        projeto.labMaker( alunoEntity.isLabMaker() );
        projeto.participouSaga( alunoEntity.isParticipouSaga() );
        projeto.itinerario( alunoEntity.isItinerario() );
        projeto.visibilidade( alunoEntity.getVisibilidade() );
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

    protected ProfessoresEntity professoresToProfessoresEntity(Professores professores) {
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
        disciplinaEntity.descricao( disciplina.getDescricao() );
        disciplinaEntity.cargaHoraria( disciplina.getCargaHoraria() );

        return disciplinaEntity.build();
    }

    protected AnexoEntity anexoToAnexoEntity(Anexo anexo) {
        if ( anexo == null ) {
            return null;
        }

        AnexoEntity.AnexoEntityBuilder anexoEntity = AnexoEntity.builder();

        anexoEntity.uuid( anexo.getUuid() );
        anexoEntity.nomeArquivo( anexo.getNomeArquivo() );
        anexoEntity.url( anexo.getUrl() );
        anexoEntity.tipo( anexo.getTipo() );
        anexoEntity.dataUpload( anexo.getDataUpload() );

        return anexoEntity.build();
    }

    protected List<AnexoEntity> anexoListToAnexoEntityList(List<Anexo> list) {
        if ( list == null ) {
            return null;
        }

        List<AnexoEntity> list1 = new ArrayList<AnexoEntity>( list.size() );
        for ( Anexo anexo : list ) {
            list1.add( anexoToAnexoEntity( anexo ) );
        }

        return list1;
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

    protected AlunosEntity alunosToAlunosEntity(Alunos alunos) {
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

    protected Anexo anexoEntityToAnexo(AnexoEntity anexoEntity) {
        if ( anexoEntity == null ) {
            return null;
        }

        Anexo.AnexoBuilder anexo = Anexo.builder();

        anexo.uuid( anexoEntity.getUuid() );
        anexo.nomeArquivo( anexoEntity.getNomeArquivo() );
        anexo.url( anexoEntity.getUrl() );
        anexo.tipo( anexoEntity.getTipo() );
        anexo.dataUpload( anexoEntity.getDataUpload() );

        return anexo.build();
    }

    protected List<Anexo> anexoEntityListToAnexoList(List<AnexoEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<Anexo> list1 = new ArrayList<Anexo>( list.size() );
        for ( AnexoEntity anexoEntity : list ) {
            list1.add( anexoEntityToAnexo( anexoEntity ) );
        }

        return list1;
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

    protected Professores professoresEntityToProfessores(ProfessoresEntity professoresEntity) {
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
        disciplina.descricao( disciplinaEntity.getDescricao() );
        disciplina.cargaHoraria( disciplinaEntity.getCargaHoraria() );

        return disciplina.build();
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

    protected Alunos alunosEntityToAlunos(AlunosEntity alunosEntity) {
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
}
