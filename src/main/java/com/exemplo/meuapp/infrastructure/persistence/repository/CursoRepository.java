package com.exemplo.meuapp.infrastructure.persistence.repository;

import com.exemplo.meuapp.application.port.out.CursoGateways;
import com.exemplo.meuapp.common.mapper.CursoMapper;
import com.exemplo.meuapp.domain.model.Alunos;
import com.exemplo.meuapp.domain.model.Curso;
import com.exemplo.meuapp.infrastructure.persistence.entity.AlunosEntity;
import com.exemplo.meuapp.infrastructure.persistence.entity.CursoEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@Transactional
public class CursoRepository implements CursoGateways {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private CursoMapper cursoMapper;

    @Override
    public Curso save(Curso curso) {
        CursoEntity cursoEntity = cursoMapper.toEntity(curso);
        em.persist(cursoEntity);
        return cursoMapper.toDomain(cursoEntity);
    }

    @Override
    public Curso getCursoById(UUID cursoId) {
        CursoEntity cursoEntity = em.find(CursoEntity.class, cursoId);
        return cursoEntity != null ? cursoMapper.toDomain(cursoEntity) : null;
    }

    @Override
    public Curso getCursoByNome(String nome) {
        CursoEntity cursoEntity = em.createQuery("SELECT c FROM CursoEntity c WHERE c.nome = :nome", CursoEntity.class)
                                    .setParameter("nome", nome)
                                    .getSingleResult();
        return cursoMapper.toDomain(cursoEntity);
    }

    @Override
    public void delete(UUID cursoId) {
        CursoEntity cursoEntity = em.find(CursoEntity.class, cursoId);
        if (cursoEntity != null) {
            em.remove(cursoEntity);
        }
    }

    @Override
    public Curso update(Curso curso) {
        CursoEntity cursoEntity = cursoMapper.toEntity(curso);
        cursoEntity = em.merge(cursoEntity);
        return cursoMapper.toDomain(cursoEntity);
    }

    @Override
    public List<Curso> getAllCursos() {
        List<CursoEntity> cursoEntities = em.createQuery("SELECT c FROM CursoEntity c", CursoEntity.class)
                                            .getResultList();
        return cursoMapper.toDomain(cursoEntities);
    }


}