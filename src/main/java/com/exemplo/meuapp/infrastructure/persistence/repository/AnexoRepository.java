package com.exemplo.meuapp.infrastructure.persistence.repository;

import com.exemplo.meuapp.application.port.out.AnexoGateways;
import com.exemplo.meuapp.common.mapper.AnexoMapper;
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
public class AnexoRepository implements AnexoGateways {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private AnexoMapper anexoMapper;

    @Override
    public Anexo save(Anexo anexo) {
        AnexoEntity entity = anexoMapper.toEntity(anexo);
        em.persist(entity);
        return anexoMapper.toDomain(entity);
    }

    @Override
    public Anexo getAnexoEtapa(UUID AnexoId) {
        AnexoEntity entity = em.find(AnexoEntity.class, AnexoId);
        return entity != null ? anexoMapper.toDomain(entity) : null;
    }

    @Override
    public void delete(UUID AnexoId) {
        AnexoEntity entity = em.find(AnexoEntity.class, AnexoId);
        if (entity != null) {
            em.remove(entity);
        }
    }

    @Override
    public Anexo update(Anexo anexo) {
        AnexoEntity entity = anexoMapper.toEntity(anexo);
        AnexoEntity merged = em.merge(entity);
        return anexoMapper.toDomain(merged);
    }

    @Override
    public List<Anexo> getAllAnexosEtapa() {
        var list = em.createQuery(
                "SELECT a FROM AnexoEntity a", AnexoEntity.class
        ).getResultList();
        return list.stream()
                .map(anexoMapper::toDomain)
                .toList();
    }

    @Override
    public List<Anexo> getAnexosByEtapaId(UUID etapaId) {
        var query = em.createQuery(
                "SELECT a FROM AnexoEntity a WHERE a.etapa.id = :etapaId", AnexoEntity.class
        );
        query.setParameter("etapaId", etapaId);
        return query.getResultList().stream()
                .map(anexoMapper::toDomain)
                .toList();
    }

    @Override
    public List<Anexo> getAnexosByEtapaIdAndTipo(UUID etapaId, String tipo) {
        var query = em.createQuery(
                "SELECT a FROM AnexoEntity a WHERE a.etapa.id = :etapaId AND a.tipo = :tipo", AnexoEntity.class
        );
        query.setParameter("etapaId", etapaId);
        query.setParameter("tipo", tipo);
        return query.getResultList().stream()
                .map(anexoMapper::toDomain)
                .toList();
    }

    @Override
    public boolean existsByEtapaAndNomeArquivo(UUID uuid, String nomeArquivo) {
        var query = em.createQuery(
                "SELECT COUNT(a) > 0 FROM AnexoEntity a WHERE a.etapa.id = :etapaId AND a.nomeArquivo = :nomeArquivo",
                Boolean.class
        );
        query.setParameter("etapaId", uuid);
        query.setParameter("nomeArquivo", nomeArquivo);
        return query.getSingleResult();
    }
}
