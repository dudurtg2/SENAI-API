package com.exemplo.meuapp.common.mapper;

import com.exemplo.meuapp.domain.model.Alunos;
import com.exemplo.meuapp.domain.model.Anexo;
import com.exemplo.meuapp.domain.model.Disciplina;
import com.exemplo.meuapp.domain.model.Endereco;
import com.exemplo.meuapp.domain.model.EtapasProjeto;
import com.exemplo.meuapp.domain.model.Professores;
import com.exemplo.meuapp.domain.model.Projeto;
import com.exemplo.meuapp.domain.model.Usuarios;
import com.exemplo.meuapp.infrastructure.persistence.entity.AlunosEntity;
import com.exemplo.meuapp.infrastructure.persistence.entity.AnexoEntity;
import com.exemplo.meuapp.infrastructure.persistence.entity.DisciplinaEntity;
import com.exemplo.meuapp.infrastructure.persistence.entity.EnderecoEntity;
import com.exemplo.meuapp.infrastructure.persistence.entity.EtapasProjetoEntity;
import com.exemplo.meuapp.infrastructure.persistence.entity.ProfessoresEntity;
import com.exemplo.meuapp.infrastructure.persistence.entity.ProjetoEntity;
import com.exemplo.meuapp.infrastructure.persistence.entity.UsuariosEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-17T00:25:46-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 21.0.4 (Oracle Corporation)"
)
@Component
public class AnexoMapperImpl implements AnexoMapper {

    @Override
    public AnexoEntity toEntity(Anexo aluno) {
        if ( aluno == null ) {
            return null;
        }

        AnexoEntity.AnexoEntityBuilder anexoEntity = AnexoEntity.builder();

        anexoEntity.uuid( aluno.getUuid() );
        anexoEntity.etapa( etapasProjetoToEtapasProjetoEntity( aluno.getEtapa() ) );
        anexoEntity.nomeArquivo( aluno.getNomeArquivo() );
        anexoEntity.url( aluno.getUrl() );
        anexoEntity.tipo( aluno.getTipo() );
        anexoEntity.dataUpload( aluno.getDataUpload() );

        return anexoEntity.build();
    }

    @Override
    public Anexo toDomain(AnexoEntity alunoEntity) {
        if ( alunoEntity == null ) {
            return null;
        }

        Anexo.AnexoBuilder anexo = Anexo.builder();

        anexo.uuid( alunoEntity.getUuid() );
        anexo.etapa( etapasProjetoEntityToEtapasProjeto( alunoEntity.getEtapa() ) );
        anexo.nomeArquivo( alunoEntity.getNomeArquivo() );
        anexo.url( alunoEntity.getUrl() );
        anexo.tipo( alunoEntity.getTipo() );
        anexo.dataUpload( alunoEntity.getDataUpload() );

        return anexo.build();
    }

    @Override
    public List<Anexo> toDomain(List<AnexoEntity> AnexoEtapaEntities) {
        if ( AnexoEtapaEntities == null ) {
            return null;
        }

        List<Anexo> list = new ArrayList<Anexo>( AnexoEtapaEntities.size() );
        for ( AnexoEntity anexoEntity : AnexoEtapaEntities ) {
            list.add( toDomain( anexoEntity ) );
        }

        return list;
    }

    @Override
    public List<AnexoEntity> toEntity(List<Anexo> Anexo) {
        if ( Anexo == null ) {
            return null;
        }

        List<AnexoEntity> list = new ArrayList<AnexoEntity>( Anexo.size() );
        for ( Anexo anexo : Anexo ) {
            list.add( toEntity( anexo ) );
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
        disciplinaEntity.descricao( disciplina.getDescricao() );
        disciplinaEntity.cargaHoraria( disciplina.getCargaHoraria() );

        return disciplinaEntity.build();
    }

    protected AlunosEntity alunosToAlunosEntity(Alunos alunos) {
        if ( alunos == null ) {
            return null;
        }

        AlunosEntity.AlunosEntityBuilder alunosEntity = AlunosEntity.builder();

        alunosEntity.uuid( alunos.getUuid() );
        alunosEntity.usuarios( usuariosToUsuariosEntity( alunos.getUsuarios() ) );
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
        projetoEntity.turma( projeto.getTurma() );
        projetoEntity.labMaker( projeto.isLabMaker() );
        projetoEntity.participouSaga( projeto.isParticipouSaga() );
        projetoEntity.itinerario( projeto.isItinerario() );
        projetoEntity.disciplina( disciplinaToDisciplinaEntity( projeto.getDisciplina() ) );
        projetoEntity.anexos( toEntity( projeto.getAnexos() ) );
        projetoEntity.lider( alunosToAlunosEntity( projeto.getLider() ) );
        projetoEntity.bannerUrl( projeto.getBannerUrl() );
        projetoEntity.codigo( projeto.getCodigo() );
        projetoEntity.visibilidade( projeto.getVisibilidade() );
        projetoEntity.status( projeto.getStatus() );
        projetoEntity.criadoEm( projeto.getCriadoEm() );
        projetoEntity.atualizadoEm( projeto.getAtualizadoEm() );

        return projetoEntity.build();
    }

    protected EtapasProjetoEntity etapasProjetoToEtapasProjetoEntity(EtapasProjeto etapasProjeto) {
        if ( etapasProjeto == null ) {
            return null;
        }

        EtapasProjetoEntity.EtapasProjetoEntityBuilder etapasProjetoEntity = EtapasProjetoEntity.builder();

        etapasProjetoEntity.uuid( etapasProjeto.getUuid() );
        etapasProjetoEntity.projeto( projetoToProjetoEntity( etapasProjeto.getProjeto() ) );
        etapasProjetoEntity.nomeEtapa( etapasProjeto.getNomeEtapa() );
        etapasProjetoEntity.descricao( etapasProjeto.getDescricao() );
        etapasProjetoEntity.ordem( etapasProjeto.getOrdem() );
        etapasProjetoEntity.status( etapasProjeto.getStatus() );
        etapasProjetoEntity.criadoEm( etapasProjeto.getCriadoEm() );
        etapasProjetoEntity.atualizadoEm( etapasProjeto.getAtualizadoEm() );

        return etapasProjetoEntity.build();
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

    protected Alunos alunosEntityToAlunos(AlunosEntity alunosEntity) {
        if ( alunosEntity == null ) {
            return null;
        }

        Alunos.AlunosBuilder alunos = Alunos.builder();

        alunos.uuid( alunosEntity.getUuid() );
        alunos.usuarios( usuariosEntityToUsuarios( alunosEntity.getUsuarios() ) );
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
        projeto.turma( projetoEntity.getTurma() );
        projeto.bannerUrl( projetoEntity.getBannerUrl() );
        projeto.codigo( projetoEntity.getCodigo() );
        projeto.anexos( toDomain( projetoEntity.getAnexos() ) );
        projeto.disciplina( disciplinaEntityToDisciplina( projetoEntity.getDisciplina() ) );
        projeto.lider( alunosEntityToAlunos( projetoEntity.getLider() ) );
        projeto.labMaker( projetoEntity.isLabMaker() );
        projeto.participouSaga( projetoEntity.isParticipouSaga() );
        projeto.itinerario( projetoEntity.isItinerario() );
        projeto.visibilidade( projetoEntity.getVisibilidade() );
        projeto.status( projetoEntity.getStatus() );
        projeto.criadoEm( projetoEntity.getCriadoEm() );
        projeto.atualizadoEm( projetoEntity.getAtualizadoEm() );

        return projeto.build();
    }

    protected EtapasProjeto etapasProjetoEntityToEtapasProjeto(EtapasProjetoEntity etapasProjetoEntity) {
        if ( etapasProjetoEntity == null ) {
            return null;
        }

        EtapasProjeto.EtapasProjetoBuilder etapasProjeto = EtapasProjeto.builder();

        etapasProjeto.uuid( etapasProjetoEntity.getUuid() );
        etapasProjeto.projeto( projetoEntityToProjeto( etapasProjetoEntity.getProjeto() ) );
        etapasProjeto.nomeEtapa( etapasProjetoEntity.getNomeEtapa() );
        etapasProjeto.descricao( etapasProjetoEntity.getDescricao() );
        etapasProjeto.ordem( etapasProjetoEntity.getOrdem() );
        etapasProjeto.status( etapasProjetoEntity.getStatus() );
        etapasProjeto.criadoEm( etapasProjetoEntity.getCriadoEm() );
        etapasProjeto.atualizadoEm( etapasProjetoEntity.getAtualizadoEm() );

        return etapasProjeto.build();
    }
}
