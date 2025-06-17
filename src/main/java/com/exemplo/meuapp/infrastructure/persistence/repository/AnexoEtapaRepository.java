package com.exemplo.meuapp.infrastructure.persistence.repository;

import com.exemplo.meuapp.application.port.out.AnexoEtapaGateways;
import com.exemplo.meuapp.common.mapper.AnexoEtapaMapper;
import com.exemplo.meuapp.domain.model.Anexo;
import com.exemplo.meuapp.infrastructure.persistence.entity.AnexoEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@Transactional
public class AnexoEtapaRepository implements AnexoEtapaGateways {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private AnexoEtapaMapper anexoEtapaMapper;

    @Override
    public Anexo save(Anexo anexo) {
        AnexoEntity entity = anexoEtapaMapper.toEntity(anexo);
        em.persist(entity);
        return anexoEtapaMapper.toDomain(entity);
    }

    @Override
    public Anexo getAnexoEtapa(UUID anexoEtapaId) {
        AnexoEntity entity = em.find(AnexoEntity.class, anexoEtapaId);
        return entity != null ? anexoEtapaMapper.toDomain(entity) : null;
    }

    @Override
    public void delete(UUID anexoEtapaId) {
        AnexoEntity entity = em.find(AnexoEntity.class, anexoEtapaId);
        if (entity != null) {
            em.remove(entity);
        }
    }

    @Override
    public Anexo update(Anexo anexo) {
        AnexoEntity entity = anexoEtapaMapper.toEntity(anexo);
        AnexoEntity merged = em.merge(entity);
        return anexoEtapaMapper.toDomain(merged);
    }

    @Override
    public List<Anexo> getAllAnexosEtapa() {
        var list = em.createQuery(
                "SELECT a FROM AnexoEtapaEntity a", AnexoEntity.class
        ).getResultList();
        return list.stream()
                .map(anexoEtapaMapper::toDomain)
                .toList();
    }

    @Override
    public List<Anexo> getAnexosByEtapaId(UUID etapaId) {
        var query = em.createQuery(
                "SELECT a FROM AnexoEtapaEntity a WHERE a.etapa.id = :etapaId", AnexoEntity.class
        );
        query.setParameter("etapaId", etapaId);
        return query.getResultList().stream()
                .map(anexoEtapaMapper::toDomain)
                .toList();
    }

    @Override
    public List<Anexo> getAnexosByEtapaIdAndTipo(UUID etapaId, String tipo) {
        var query = em.createQuery(
                "SELECT a FROM AnexoEtapaEntity a WHERE a.etapa.id = :etapaId AND a.tipo = :tipo", AnexoEntity.class
        );
        query.setParameter("etapaId", etapaId);
        query.setParameter("tipo", tipo);
        return query.getResultList().stream()
                .map(anexoEtapaMapper::toDomain)
                .toList();
    }

    @Override
    public boolean existsByEtapaAndNomeArquivo(UUID uuid, String nomeArquivo) {
        var query = em.createQuery(
                "SELECT COUNT(a) > 0 FROM AnexoEtapaEntity a WHERE a.etapa.id = :etapaId AND a.nomeArquivo = :nomeArquivo",
                Boolean.class
        );
        query.setParameter("etapaId", uuid);
        query.setParameter("nomeArquivo", nomeArquivo);
        return query.getSingleResult();
    }
}
