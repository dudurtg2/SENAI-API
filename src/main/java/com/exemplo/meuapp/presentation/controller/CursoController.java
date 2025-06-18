package com.exemplo.meuapp.presentation.controller;

import com.exemplo.meuapp.application.port.in.curso.AtualizarCursoUseCase;

import com.exemplo.meuapp.application.port.in.curso.EncontrarCursoUseCase;
import com.exemplo.meuapp.common.mapper.CursoMapper;
import com.exemplo.meuapp.infrastructure.persistence.entity.CursoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.exemplo.meuapp.application.port.in.curso.CriarCursoUseCase;
import com.exemplo.meuapp.application.port.in.curso.DeletarCursoUseCase;
import com.exemplo.meuapp.domain.model.Curso;
import org.springframework.web.context.annotation.RequestScope;

import java.util.UUID;

@RestController
@RequestScope
@CrossOrigin
@RequestMapping("/api/v1/senai/Curso")
public class CursoController {

    @Autowired
   
    private CursoMapper mapper;
    private CriarCursoUseCase criarCursoUseCase;
    private EncontrarCursoUseCase encontrarCursoUseCase;
    private DeletarCursoUseCase deleteCursoUseCase;
    private AtualizarCursoUseCase atualizarCursoUseCase;

    @Autowired
    public CursoController(
            CursoMapper mapper,
            CriarCursoUseCase criarCursoUseCase,
            EncontrarCursoUseCase encontrarCursoUseCase,
            DeletarCursoUseCase deleteCursoUseCase,
            AtualizarCursoUseCase atualizarCursoUseCase) {
        this.mapper = mapper;
        this.criarCursoUseCase = criarCursoUseCase;
        this.encontrarCursoUseCase = encontrarCursoUseCase;
        this.deleteCursoUseCase = deleteCursoUseCase;
        this.atualizarCursoUseCase = atualizarCursoUseCase;
    }

    public @PostMapping("/create")
    ResponseEntity<?> create(@RequestBody Curso request) {
        try {

            Curso Curso = criarCursoUseCase.criar(request);
            CursoEntity response = mapper.toEntity(Curso);

            return new ResponseEntity<CursoEntity>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<Exception>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public @GetMapping("/findAll")
    ResponseEntity<?> findAll() {
        try {
            return new ResponseEntity<>(encontrarCursoUseCase.buscarTodos(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Exception>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public @GetMapping("/findByUUID/{uuid}")
    ResponseEntity<?> findByUUID(@PathVariable("uuid") String uuid) {
        try {
            Curso Curso = encontrarCursoUseCase.buscarPorUUID(UUID.fromString(uuid));
            CursoEntity response = mapper.toEntity(Curso);
            return new ResponseEntity<CursoEntity>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Exception>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public @PutMapping("/update/{uuid}")
    ResponseEntity<?> update(@PathVariable("uuid") String uuid, @RequestBody Curso request) {
        try {
            Curso Curso = atualizarCursoUseCase.atualizar(UUID.fromString(uuid), request);
            CursoEntity response = mapper.toEntity(Curso);
            return new ResponseEntity<CursoEntity>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Exception>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public @DeleteMapping("/delete/{uuid}")
    ResponseEntity<?> delete(@PathVariable("uuid") String uuid) {
        try {
            deleteCursoUseCase.deletar(UUID.fromString(uuid));
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<Exception>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public @GetMapping("/findByNome/{nome}")
    ResponseEntity<?> findByNome(@PathVariable("nome") String nome) {
        try {
            return new ResponseEntity<>(encontrarCursoUseCase.buscarPorNome(nome), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Exception>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
