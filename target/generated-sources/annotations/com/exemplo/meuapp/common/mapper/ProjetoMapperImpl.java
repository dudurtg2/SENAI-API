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
    date = "2025-06-18T15:18:33-0300",
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

        projetoEntity.anexos( anexoListToAnexoEntityList( aluno.getAnexos() ) );
        projetoEntity.atualizadoEm( aluno.getAtualizadoEm() );
        projetoEntity.bannerUrl( aluno.getBannerUrl() );
        projetoEntity.codigo( aluno.getCodigo() );
        projetoEntity.criadoEm( aluno.getCriadoEm() );
        projetoEntity.descricao( aluno.getDescricao() );
        projetoEntity.disciplina( disciplinaToDisciplinaEntity( aluno.getDisciplina() ) );
        projetoEntity.itinerario( aluno.isItinerario() );
        projetoEntity.labMaker( aluno.isLabMaker() );
        projetoEntity.lider( alunosToAlunosEntity( aluno.getLider() ) );
        projetoEntity.participouSaga( aluno.isParticipouSaga() );
        projetoEntity.status( aluno.getStatus() );
        projetoEntity.titulo( aluno.getTitulo() );
        projetoEntity.turma( aluno.getTurma() );
        projetoEntity.uuid( aluno.getUuid() );
        projetoEntity.visibilidade( aluno.getVisibilidade() );

        return projetoEntity.build();
    }

    @Override
    public Projeto toDomain(ProjetoEntity alunoEntity) {
        if ( alunoEntity == null ) {
            return null;
        }

        Projeto.ProjetoBuilder projeto = Projeto.builder();

        projeto.anexos( anexoEntityListToAnexoList( alunoEntity.getAnexos() ) );
        projeto.atualizadoEm( alunoEntity.getAtualizadoEm() );
        projeto.bannerUrl( alunoEntity.getBannerUrl() );
        projeto.codigo( alunoEntity.getCodigo() );
        projeto.criadoEm( alunoEntity.getCriadoEm() );
        projeto.descricao( alunoEntity.getDescricao() );
        projeto.disciplina( disciplinaEntityToDisciplina( alunoEntity.getDisciplina() ) );
        projeto.itinerario( alunoEntity.isItinerario() );
        projeto.labMaker( alunoEntity.isLabMaker() );
        projeto.lider( alunosEntityToAlunos( alunoEntity.getLider() ) );
        projeto.participouSaga( alunoEntity.isParticipouSaga() );
        projeto.status( alunoEntity.getStatus() );
        projeto.titulo( alunoEntity.getTitulo() );
        projeto.turma( alunoEntity.getTurma() );
        projeto.uuid( alunoEntity.getUuid() );
        projeto.visibilidade( alunoEntity.getVisibilidade() );

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

    protected AnexoEntity anexoToAnexoEntity(Anexo anexo) {
        if ( anexo == null ) {
            return null;
        }

        AnexoEntity.AnexoEntityBuilder anexoEntity = AnexoEntity.builder();

        anexoEntity.dataUpload( anexo.getDataUpload() );
        anexoEntity.nomeArquivo( anexo.getNomeArquivo() );
        anexoEntity.tipo( anexo.getTipo() );
        anexoEntity.url( anexo.getUrl() );
        anexoEntity.uuid( anexo.getUuid() );

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
        disciplinaEntity.cargaHoraria( disciplina.getCargaHoraria() );
        disciplinaEntity.criadoEm( disciplina.getCriadoEm() );
        disciplinaEntity.descricao( disciplina.getDescricao() );
        disciplinaEntity.nome( disciplina.getNome() );
        disciplinaEntity.professor( professoresToProfessoresEntity( disciplina.getProfessor() ) );
        disciplinaEntity.uuid( disciplina.getUuid() );

        return disciplinaEntity.build();
    }

    protected CursoEntity cursoToCursoEntity(Curso curso) {
        if ( curso == null ) {
            return null;
        }

        CursoEntity.CursoEntityBuilder cursoEntity = CursoEntity.builder();

        cursoEntity.cargaHoraria( curso.getCargaHoraria() );
        cursoEntity.descricao( curso.getDescricao() );
        cursoEntity.nome( curso.getNome() );
        cursoEntity.uuid( curso.getUuid() );

        return cursoEntity.build();
    }

    protected AlunosEntity alunosToAlunosEntity(Alunos alunos) {
        if ( alunos == null ) {
            return null;
        }

        AlunosEntity.AlunosEntityBuilder alunosEntity = AlunosEntity.builder();

        alunosEntity.atualizadoEm( alunos.getAtualizadoEm() );
        alunosEntity.criadoEm( alunos.getCriadoEm() );
        alunosEntity.curso( cursoToCursoEntity( alunos.getCurso() ) );
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

    protected Anexo anexoEntityToAnexo(AnexoEntity anexoEntity) {
        if ( anexoEntity == null ) {
            return null;
        }

        Anexo.AnexoBuilder anexo = Anexo.builder();

        anexo.dataUpload( anexoEntity.getDataUpload() );
        anexo.nomeArquivo( anexoEntity.getNomeArquivo() );
        anexo.tipo( anexoEntity.getTipo() );
        anexo.url( anexoEntity.getUrl() );
        anexo.uuid( anexoEntity.getUuid() );

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
        disciplina.cargaHoraria( disciplinaEntity.getCargaHoraria() );
        disciplina.criadoEm( disciplinaEntity.getCriadoEm() );
        disciplina.descricao( disciplinaEntity.getDescricao() );
        disciplina.nome( disciplinaEntity.getNome() );
        disciplina.professor( professoresEntityToProfessores( disciplinaEntity.getProfessor() ) );
        disciplina.uuid( disciplinaEntity.getUuid() );

        return disciplina.build();
    }

    protected Curso cursoEntityToCurso(CursoEntity cursoEntity) {
        if ( cursoEntity == null ) {
            return null;
        }

        Curso.CursoBuilder curso = Curso.builder();

        curso.cargaHoraria( cursoEntity.getCargaHoraria() );
        curso.descricao( cursoEntity.getDescricao() );
        curso.nome( cursoEntity.getNome() );
        curso.uuid( cursoEntity.getUuid() );

        return curso.build();
    }

    protected Alunos alunosEntityToAlunos(AlunosEntity alunosEntity) {
        if ( alunosEntity == null ) {
            return null;
        }

        Alunos.AlunosBuilder alunos = Alunos.builder();

        alunos.atualizadoEm( alunosEntity.getAtualizadoEm() );
        alunos.criadoEm( alunosEntity.getCriadoEm() );
        alunos.curso( cursoEntityToCurso( alunosEntity.getCurso() ) );
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
}
