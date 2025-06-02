package com.exemplo.meuapp.presentation.controller;

import com.exemplo.meuapp.application.port.in.alunos.AtualizarAlunosUseCase;
import com.exemplo.meuapp.application.port.in.alunos.DeletarAlunosUseCase;
import com.exemplo.meuapp.application.port.in.alunos.EncontrarAlunosUseCase;
import com.exemplo.meuapp.application.port.in.usuarios.EncontrarUsuariosUseCase;
import com.exemplo.meuapp.common.mapper.AlunosMapper;
import com.exemplo.meuapp.infrastructure.persistence.entity.AlunosEntity;
import com.exemplo.meuapp.infrastructure.webclient.CollectEmailForTokenService;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.exemplo.meuapp.application.port.in.alunos.CriarAlunosUseCase;
import com.exemplo.meuapp.domain.model.Alunos;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/senai/alunos")
public class AlunosController {

    @Autowired
    @Qualifier("alunosMapperImpl")
    private AlunosMapper mapper;
    private CriarAlunosUseCase criarAlunosUseCase;
    private EncontrarAlunosUseCase encontrarAlunosUseCase;
    private DeletarAlunosUseCase deletarAlunosUseCase;
    private AtualizarAlunosUseCase atualizarAlunosUseCase;
    private EncontrarUsuariosUseCase encontrarUsuariosUseCase;
    private CollectEmailForTokenService collectEmailForTokenService;

    @Autowired
    public AlunosController(
            @Qualifier("alunosMapperImpl") AlunosMapper mapper,
            CriarAlunosUseCase criarAlunosUseCase,
            EncontrarAlunosUseCase encontrarAlunosUseCase,
            DeletarAlunosUseCase deletarAlunosUseCase,
            AtualizarAlunosUseCase atualizarAlunosUseCase,
            EncontrarUsuariosUseCase encontrarUsuariosUseCase,
            CollectEmailForTokenService collectEmailForTokenService) {
        this.mapper = mapper;
        this.criarAlunosUseCase = criarAlunosUseCase;
        this.encontrarAlunosUseCase = encontrarAlunosUseCase;
        this.deletarAlunosUseCase = deletarAlunosUseCase;
        this.encontrarUsuariosUseCase = encontrarUsuariosUseCase;
        this.collectEmailForTokenService = collectEmailForTokenService;
        this.atualizarAlunosUseCase = atualizarAlunosUseCase;
    }

    public @PostMapping("/create")
    ResponseEntity<?> create(@RequestBody Alunos request, HttpServletRequest httpServletRequest) {
        try {
            request.setUsuarios(encontrarUsuariosUseCase.buscarPorEmailUser(
                    collectEmailForTokenService.execute(httpServletRequest)));
            Alunos alunos = criarAlunosUseCase.criar(request);
           
            AlunosEntity response = mapper.toEntity(alunos);

            return new ResponseEntity<AlunosEntity>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<Exception>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        try {
            return new ResponseEntity<>(encontrarAlunosUseCase.buscarTodos(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Exception>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findByUUID/{uuid}")
    public ResponseEntity<?> findByUUID(@PathVariable("uuid") String uuid) {
        try {
            Alunos alunos = encontrarAlunosUseCase.buscarPorUuid(UUID.fromString(uuid));
            AlunosEntity response = mapper.toEntity(alunos);
            return new ResponseEntity<AlunosEntity>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Exception>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{uuid}")
    public ResponseEntity<?> update(@PathVariable("uuid") String uuid, @RequestBody Alunos request) {
        try {
            Alunos alunos = atualizarAlunosUseCase.atualizar(UUID.fromString(uuid), request);
            AlunosEntity response = mapper.toEntity(alunos);
            return new ResponseEntity<AlunosEntity>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Exception>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{uuid}")
    public ResponseEntity<?> delete(@PathVariable("uuid") String uuid) {
        try {
            deletarAlunosUseCase.deletar(UUID.fromString(uuid));
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<Exception>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findByMatricula/{matricula}")
    public ResponseEntity<?> findByMatricula(@PathVariable("matricula") String matricula) {
        try {
            return new ResponseEntity<>(encontrarAlunosUseCase.buscarPorMatricula(matricula), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Exception>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
