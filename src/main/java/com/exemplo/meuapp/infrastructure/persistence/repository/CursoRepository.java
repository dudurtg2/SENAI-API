package com.exemplo.meuapp.infrastructure.persistence.repository;

import com.exemplo.meuapp.application.port.out.CursoGateways;
import com.exemplo.meuapp.domain.model.Curso;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.*;

@Repository
public class CursoRepository implements CursoGateways {

    // In-memory storage for demo purposes (replace with actual database persistence)
    private final Map<UUID, Curso> cursos = new HashMap<>();

    @Override
    public Curso save(Curso curso) {
        if (curso.getUuid() == null) {
            curso.setUuid(UUID.randomUUID());
            curso.setCriadoEm(LocalDateTime.now());
        }
        curso.setAtualizadoEm(LocalDateTime.now());
        cursos.put(curso.getUuid(), curso);
        return curso;
    }

    @Override
    public Curso getCursoById(UUID cursoId) {
        return cursos.get(cursoId);
    }

    @Override
    public void delete(UUID cursoId) {
        cursos.remove(cursoId);
    }

    @Override
    public Curso update(Curso curso) {
        if (curso.getUuid() != null && cursos.containsKey(curso.getUuid())) {
            curso.setAtualizadoEm(LocalDateTime.now());
            cursos.put(curso.getUuid(), curso);
            return curso;
        }
        throw new IllegalArgumentException("Curso não encontrado para atualização");
    }

    @Override
    public List<Curso> getAllCursos() {
        return new ArrayList<>(cursos.values());
    }

    @Override
    public Curso findByCodigo(String codigo) {
        return cursos.values().stream()
                .filter(curso -> codigo.equals(curso.getCodigo()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Curso> findByNivel(String nivel) {
        return cursos.values().stream()
                .filter(curso -> nivel.equals(curso.getNivel()))
                .toList();
    }

    @Override
    public List<Curso> findAtivos() {
        return cursos.values().stream()
                .filter(curso -> Boolean.TRUE.equals(curso.getAtivo()))
                .toList();
    }
}