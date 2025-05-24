package com.exemplo.meuapp.presentation.controller;

import com.exemplo.meuapp.common.mapper.AlunosMapper;
import com.exemplo.meuapp.infrastructure.persistence.entity.AlunosEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exemplo.meuapp.application.port.in.alunos.CriarAlunosUseCase;
import com.exemplo.meuapp.domain.model.Alunos;

@RestController
@RequestMapping("/api/v1/senai/alunos")
public class AlunosController {

    private AlunosMapper mapper;
    private CriarAlunosUseCase criarAlunosUseCase;

    @Autowired
    public AlunosController(AlunosMapper mapper, CriarAlunosUseCase criarAlunosUseCase) {
        this.mapper = mapper;
        this.criarAlunosUseCase = criarAlunosUseCase;
    }

    @PostMapping("/create")
    ResponseEntity<?> create(@RequestBody Alunos request) {
        try {

            Alunos alunos = criarAlunosUseCase.criar(request);
            AlunosEntity response = mapper.toEntity(alunos);

            return new ResponseEntity<AlunosEntity>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<Exception>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    

}
