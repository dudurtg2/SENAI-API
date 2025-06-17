package com.exemplo.meuapp.application.port.in.curso;

import com.exemplo.meuapp.application.port.out.CursoGateways;
import com.exemplo.meuapp.domain.exception.RegraDeNegocioException;
import com.exemplo.meuapp.domain.model.Curso;
import java.util.UUID;

public class AtualizarCursoUseCase {
    private final CursoGateways CursoGateways;

    public AtualizarCursoUseCase(CursoGateways CursoGateways) {
        this.CursoGateways = CursoGateways;
    }

    public Curso atualizar(UUID uuid, Curso curso) {
        Curso CursoInDb = CursoGateways.getCursoById(uuid);
        if (CursoInDb == null) {
            throw new RegraDeNegocioException("Curso não encontrado.");
        }

        curso.correct();

      
        CursoInDb.setCargaHoraria(curso.getCargaHoraria());
        CursoInDb.setDescricao(curso.getDescricao());
        CursoInDb.setNome(curso.getNome());

        return CursoGateways.update(CursoInDb);
    }
}