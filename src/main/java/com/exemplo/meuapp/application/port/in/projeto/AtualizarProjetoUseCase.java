package com.exemplo.meuapp.application.port.in.projeto;

import com.exemplo.meuapp.application.port.out.ProjetoGateways;
import com.exemplo.meuapp.domain.model.Projeto;

import java.time.LocalDateTime;
import java.util.UUID;

public class AtualizarProjetoUseCase {
    private ProjetoGateways projetoGateways;

    public AtualizarProjetoUseCase(ProjetoGateways projetoGateways) {
        this.projetoGateways = projetoGateways;
    }

    public Projeto atualizar(UUID uuid, Projeto projeto) {
        Projeto projetoInDb = projetoGateways.getProjetoById(uuid);
        projetoInDb.setTitulo(projeto.getTitulo());
        projetoInDb.setDescricao(projeto.getDescricao());
        projetoInDb.setCurso(projeto.getCurso());
        projetoInDb.setTurma(projeto.getTurma());
        projetoInDb.setLabMaker(projeto.isLabMaker());
        projetoInDb.setParticipouSaga(projeto.isParticipouSaga());
        projetoInDb.setItinerario(projeto.isItinerario());
        projetoInDb.setUnidadeCurricular(projeto.getUnidadeCurricular());
        projetoInDb.setLiderProjeto(projeto.getLiderProjeto());
        projetoInDb.setBannerUrl(projeto.getBannerUrl());
        projetoInDb.setCodigo(projeto.getCodigo());
        projetoInDb.setVisibilidadeCodigo(projeto.getVisibilidadeCodigo());
        projetoInDb.setVisibilidadeAnexos(projeto.getVisibilidadeAnexos());
        projetoInDb.setStatus(projeto.getStatus());
        projetoInDb.setAtualizadoEm(LocalDateTime.now());
        return projetoGateways.update(projetoInDb);
    }
}
