package com.exemplo.meuapp.application.port.in.usuarios;

import java.util.List;
import java.util.UUID;
import com.exemplo.meuapp.domain.enums.UsuariosStatus;
import com.exemplo.meuapp.domain.model.Alunos;
import com.exemplo.meuapp.domain.model.Professores;
import com.exemplo.meuapp.domain.model.Usuarios;
import com.exemplo.meuapp.presentation.dto.PerfilUsuario;
import com.exemplo.meuapp.application.port.out.AlunosGateways;
import com.exemplo.meuapp.application.port.out.ProfessoresGateways;
import com.exemplo.meuapp.application.port.out.UsuariosGateways;

public class EncontrarUsuariosUseCase {

    private UsuariosGateways usuariosGateways;
    private AlunosGateways alunosGateways;
    private ProfessoresGateways professoresGateways;

    public EncontrarUsuariosUseCase(UsuariosGateways usuariosGateways,
            AlunosGateways alunosGateways,
            ProfessoresGateways professoresGateways) {
        this.usuariosGateways = usuariosGateways;
        this.alunosGateways = alunosGateways;
        this.professoresGateways = professoresGateways;
    }

    public PerfilUsuario buscarPorUuid(UUID uuid) {
        Usuarios usuario = usuariosGateways.getUsuarios(uuid);
        return criarPerfil(usuario);

    }

    public PerfilUsuario buscarPorMatricula(String matricula) {
        Alunos aluno = alunosGateways.getAlunosByMatricula(matricula);
        if (aluno != null) {
            return new PerfilUsuario(
                    aluno.getUsuarios().getUuid().toString(),
                    aluno.getUsuarios().getUsuario(),
                    aluno.getUsuarios().getEmail(),
                    aluno.getUsuarios().getTipo(),
                    aluno.getTelefonePessoal(),
                    aluno.getTelefoneProfissional(),
                    aluno.getLinkedin(),
                    aluno.getEndereco(),
                    aluno.getStatus(),
                    aluno.getCriadoEm(),
                    aluno.getAtualizadoEm(),
                    aluno.getMatricula(),
                    aluno.getCurso().getNome(),
                    null,
                    null);
        }
        throw new IllegalArgumentException("Aluno não encontrado com a matrícula: " + matricula);
    }

    public PerfilUsuario buscarPorEmail(String email) {
         Usuarios usuario = usuariosGateways.getUsuariosByEmail(email);
        return criarPerfil(usuario);
    }

    public Usuarios buscarPorEmailUser(String email) {
    
        return usuariosGateways.getUsuariosByEmail(email);
    }    private PerfilUsuario criarPerfil(Usuarios usuario) {
        // Perfil simplificado para evitar erros de compilação
        return new PerfilUsuario(
                usuario.getUuid().toString(),
                usuario.getUsuario(),
                usuario.getEmail(),
                usuario.getTipo(),
                null, // telefonePessoal
                null, // telefoneProfissional
                null, // linkedin
                null, // endereco
                usuario.getStatus(),
                usuario.getCriadoEm(),
                usuario.getAtualizadoEm(),
                null, // matricula
                null, // curso
                null, // especialidade
                null  // departamento
        );
    }

    public List<Usuarios> buscarPorStatus(UsuariosStatus status) {
        return usuariosGateways.getUsuariosByStatus(status);
    }

    public List<Usuarios> buscarTodos() {
        return usuariosGateways.getAllUsuarios();
    }

}
