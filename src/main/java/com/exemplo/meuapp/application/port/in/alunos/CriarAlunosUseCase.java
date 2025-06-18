package com.exemplo.meuapp.application.port.in.alunos;

import com.exemplo.meuapp.application.port.out.AlunosGateways;
import com.exemplo.meuapp.application.port.out.CursoGateways;
import com.exemplo.meuapp.application.port.out.UsuariosGateways;
import com.exemplo.meuapp.common.mapper.UsuariosMapper;
import com.exemplo.meuapp.domain.enums.UsuarioTipo;
import com.exemplo.meuapp.domain.enums.UsuariosStatus;
import com.exemplo.meuapp.domain.exception.DadosInvalidosException;
import com.exemplo.meuapp.domain.exception.RegraDeNegocioException;
import com.exemplo.meuapp.domain.model.Alunos;
import com.exemplo.meuapp.domain.model.Curso;
import com.exemplo.meuapp.infrastructure.persistence.entity.CursoEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDateTime;

public class CriarAlunosUseCase {

    private AlunosGateways alunosGateways;
    private UsuariosGateways usuariosGateways;
    private UsuariosMapper usuariosMapper;
    private CursoGateways cursoGateways;

    public CriarAlunosUseCase(AlunosGateways alunosGateways, UsuariosGateways usuariosGateways,
            UsuariosMapper usuariosMapper, CursoGateways cursoGateways) {
        this.alunosGateways = alunosGateways;
        this.usuariosGateways = usuariosGateways;
        this.usuariosMapper = usuariosMapper;
        this.cursoGateways = cursoGateways;
    }

    public Alunos criar(Alunos alunos) {
        alunos.setCriadoEm(LocalDateTime.now());
        alunos.setAtualizadoEm(LocalDateTime.now());
        alunos.setStatus(UsuariosStatus.ATIVO);

        if (alunos.getUsuarios().getUuid() != null) {
            alunos.setUsuarios(usuariosGateways.getUsuarios(alunos.getUsuarios().getUuid()));
        }else{
            alunos.getUsuarios().setSenha(new BCryptPasswordEncoder().encode(alunos.getUsuarios().getSenha()));
        }


        if (usuariosGateways.getUsuariosByEmail(alunos.getUsuarios().getEmail()) != null) {
            throw new RegraDeNegocioException("Já existe um aluno vinculado a este usuário.");
        }

        Curso curso = cursoGateways.getCursoById(alunos.getCurso().getUuid());

        if (curso == null) {
            throw new RegraDeNegocioException("Curso não encontrado.");
        }
        alunos.setCurso(curso);

        if (alunos.getUsuarios().getStatus() == null
                || !alunos.getUsuarios().getStatus().name().equals("ATIVO")) {
            throw new RegraDeNegocioException("Usuário associado ao professor está inativo ou não informado.");
        }

        if (alunosGateways.existsByMatricula(alunos.getMatricula())) {
            throw new RegraDeNegocioException("Já existe um aluno com esta matrícula.");
        }

        if (alunos.getTelefonePessoal() != null && alunos.getTelefonePessoal().replaceAll("\\D", "").length() < 10) {
            throw new DadosInvalidosException("Telefone pessoal inválido.");
        }
        if (alunos.getTelefoneProfissional() != null
                && alunos.getTelefoneProfissional().replaceAll("\\D", "").length() < 10) {
            throw new DadosInvalidosException("Telefone profissional inválido.");
        }

        if (alunos.getLinkedin() != null && !alunos.getLinkedin().isBlank()) {
            if (!alunos.getLinkedin().startsWith("https://") || !alunos.getLinkedin().contains("linkedin.com")) {
                throw new DadosInvalidosException("URL do LinkedIn inválida.");
            }
        }

        if (alunos.getStatus() != null && alunos.getStatus().name().equals("INATIVO")) {
            throw new RegraDeNegocioException("Não é permitido cadastrar aluno com status INATIVO.");
        }

        alunos.getUsuarios().setTipo(UsuarioTipo.ALUNO);

        return alunosGateways.save(alunos.correct());
    }
}
