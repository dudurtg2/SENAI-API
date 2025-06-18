package com.exemplo.meuapp.application.port.in.professor;

import com.exemplo.meuapp.application.port.out.ProfessoresGateways;
import com.exemplo.meuapp.application.port.out.UsuariosGateways;
import com.exemplo.meuapp.common.mapper.UsuariosMapper;
import com.exemplo.meuapp.domain.enums.UsuarioTipo;
import com.exemplo.meuapp.domain.exception.DadosInvalidosException;
import com.exemplo.meuapp.domain.exception.RegraDeNegocioException;
import com.exemplo.meuapp.domain.model.Professores;
import com.exemplo.meuapp.domain.model.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDateTime;

public class CriarProfessorUseCase {
    private ProfessoresGateways professoresGateways;
    private UsuariosGateways usuariosGateways;
    private UsuariosMapper usuariosMapper;

    public CriarProfessorUseCase(ProfessoresGateways professoresGateways, UsuariosGateways usuariosGateways, UsuariosMapper usuariosMapper) {
        this.professoresGateways = professoresGateways;
        this.usuariosGateways = usuariosGateways;
        this.usuariosMapper = usuariosMapper;
    }

    public Professores criar(Professores professores) {

        if (professores.getUsuarios().getUuid() != null) {
            professores.setUsuarios(usuariosGateways.getUsuarios(professores.getUsuarios().getUuid()));
        }else{
            professores.getUsuarios().setSenha(new BCryptPasswordEncoder().encode(professores.getUsuarios().getSenha()));
        }
        if(usuariosGateways.getUsuariosByEmail(professores.getUsuarios().getEmail()) != null){
            throw new RegraDeNegocioException("Já existe um professor vinculado a este usuário.");
        }

        if (professores.getUsuarios().getStatus() == null
                || !professores.getUsuarios().getStatus().name().equals("ATIVO")) {
            throw new RegraDeNegocioException("Usuário associado ao professor está inativo ou não informado.");
        }

     
        if (professores.getTelefoneProfissional() != null &&
                !professores.getTelefoneProfissional().matches("^\\d{10,15}$")) {
            throw new DadosInvalidosException("Telefone profissional inválido.");
        }
        if (professores.getTelefonePessoal() != null &&
                !professores.getTelefonePessoal().isBlank() &&
                !professores.getTelefonePessoal().matches("^\\d{10,15}$")) {
            throw new DadosInvalidosException("Telefone pessoal inválido.");
        }

        if (professores.getLinkedin() != null && !professores.getLinkedin().isBlank()) {
            if (!professores.getLinkedin().startsWith("https://") || !professores.getLinkedin().contains("linkedin.com")) {
                throw new DadosInvalidosException("URL do LinkedIn inválida.");
            }
        }

        professores.setCriadoEm(LocalDateTime.now());
        professores.setAtualizadoEm(LocalDateTime.now());
        professores.getUsuarios().setTipo(UsuarioTipo.PROFESSOR);
        return professoresGateways.save( professores.correct());
    }
}