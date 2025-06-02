package com.exemplo.meuapp.application.port.in.alunos;



import com.exemplo.meuapp.application.port.out.AlunosGateways;
import com.exemplo.meuapp.domain.model.Alunos;

import java.time.LocalDateTime;
import java.util.UUID;

public class AtualizarAlunosUseCase {
    private AlunosGateways alunosGateways;

    public AtualizarAlunosUseCase(AlunosGateways alunosGateways) {
        this.alunosGateways = alunosGateways;
    }
    public Alunos atualizar(UUID uuid, Alunos alunos) {
        Alunos alunosInDb = alunosGateways.getAlunos(uuid);

        alunosInDb.setAtualizadoEm(LocalDateTime.now());
        alunosInDb.setCurso(alunos.getCurso());
        alunosInDb.setStatus(alunos.getStatus());
        alunosInDb.setEndereco(alunos.getEndereco());
        alunosInDb.setTelefonePessoal(alunos.getTelefonePessoal());
        alunosInDb.setTelefoneProfissional(alunos.getTelefoneProfissional());


        return alunosGateways.update(alunosInDb);
    }
}
