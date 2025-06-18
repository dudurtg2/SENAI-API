package com.exemplo.meuapp.presentation.controller;

import com.exemplo.meuapp.application.port.in.anexo.AtualizarAnexoUseCase;
import com.exemplo.meuapp.application.port.in.anexo.CriarAnexoUseCase;
import com.exemplo.meuapp.application.port.in.anexo.DeletarAnexoUseCase;
import com.exemplo.meuapp.application.port.in.anexo.EncontrarAnexoUseCase;
import com.exemplo.meuapp.common.mapper.AnexoMapper;
import com.exemplo.meuapp.infrastructure.persistence.entity.AnexoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.exemplo.meuapp.domain.model.Anexo;
import org.springframework.web.context.annotation.RequestScope;

import java.util.UUID;

@RestController
@RequestScope
@CrossOrigin
@RequestMapping("/api/v1/senai/AnexoEtapa")
public class AnexoEtapaController {


   
    private AnexoMapper mapper;
    private CriarAnexoUseCase criarAnexoUseCase;
    private EncontrarAnexoUseCase encontrarAnexoUseCase;
    private DeletarAnexoUseCase deletarAnexoUseCase;
    private AtualizarAnexoUseCase atualizarAnexoUseCase;

    @Autowired
    public AnexoEtapaController(
            AnexoMapper mapper,
            CriarAnexoUseCase criarAnexoUseCase,
            EncontrarAnexoUseCase encontrarAnexoUseCase,
            DeletarAnexoUseCase deletarAnexoUseCase,
            AtualizarAnexoUseCase atualizarAnexoUseCase) {
        this.mapper = mapper;
        this.criarAnexoUseCase = criarAnexoUseCase;
        this.encontrarAnexoUseCase = encontrarAnexoUseCase;
        this.deletarAnexoUseCase = deletarAnexoUseCase;
        this.atualizarAnexoUseCase = atualizarAnexoUseCase;
    }

    public @PostMapping("/create")
    ResponseEntity<?> create(@RequestBody Anexo request) {
        try {

            Anexo Anexo = criarAnexoUseCase.criar(request);
            AnexoEntity response = mapper.toEntity(Anexo);

            return new ResponseEntity<AnexoEntity>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<Exception>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public @GetMapping("/findAll")
    ResponseEntity<?> findAll() {
        try {
            return new ResponseEntity<>(encontrarAnexoUseCase.buscarTodos(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Exception>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public @GetMapping("/findByUUID/{uuid}")
    ResponseEntity<?> findByUUID(@PathVariable("uuid") String uuid) {
        try {
            Anexo Anexo = encontrarAnexoUseCase.buscarPorUuid(UUID.fromString(uuid));
            AnexoEntity response = mapper.toEntity(Anexo);
            return new ResponseEntity<AnexoEntity>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Exception>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public @PutMapping("/update/{uuid}")
    ResponseEntity<?> update(@PathVariable("uuid") String uuid, @RequestBody Anexo request) {
        try {
            Anexo Anexo = atualizarAnexoUseCase.atualizar(UUID.fromString(uuid), request);
            AnexoEntity response = mapper.toEntity(Anexo);
            return new ResponseEntity<AnexoEntity>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Exception>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public @DeleteMapping("/delete/{uuid}")
    ResponseEntity<?> delete(@PathVariable("uuid") String uuid) {
        try {
            deletarAnexoUseCase.deletar(UUID.fromString(uuid));
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<Exception>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public @GetMapping("/findByEtapa/{etapa_uuid}")
    ResponseEntity<?> findByEtapa(@PathVariable("etapa_uuid") String etapa_uuid) {
        try {
            return new ResponseEntity<>(encontrarAnexoUseCase.buscarPorEtapaId(UUID.fromString(etapa_uuid)), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Exception>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public @GetMapping("/findByEtapaETipo/{etapa_uuid}/{tipo}")
    ResponseEntity<?> findByEtapaETipo(@PathVariable("etapa_uuid") String etapa_uuid, @PathVariable("tipo") String tipo) {
        try {
            return new ResponseEntity<>(encontrarAnexoUseCase.buscarPorEtapaIdETipo(UUID.fromString(etapa_uuid), tipo), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Exception>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
