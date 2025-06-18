package com.exemplo.meuapp.common.mapper;

import com.exemplo.meuapp.domain.model.Anexo;
import com.exemplo.meuapp.infrastructure.persistence.entity.AnexoEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-18T15:18:33-0300",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.42.0.v20250514-1000, environment: Java 21.0.7 (Eclipse Adoptium)"
)
@Component
public class AnexoMapperImpl implements AnexoMapper {

    @Override
    public AnexoEntity toEntity(Anexo aluno) {
        if ( aluno == null ) {
            return null;
        }

        AnexoEntity.AnexoEntityBuilder anexoEntity = AnexoEntity.builder();

        anexoEntity.dataUpload( aluno.getDataUpload() );
        anexoEntity.nomeArquivo( aluno.getNomeArquivo() );
        anexoEntity.tipo( aluno.getTipo() );
        anexoEntity.url( aluno.getUrl() );
        anexoEntity.uuid( aluno.getUuid() );

        return anexoEntity.build();
    }

    @Override
    public Anexo toDomain(AnexoEntity alunoEntity) {
        if ( alunoEntity == null ) {
            return null;
        }

        Anexo.AnexoBuilder anexo = Anexo.builder();

        anexo.dataUpload( alunoEntity.getDataUpload() );
        anexo.nomeArquivo( alunoEntity.getNomeArquivo() );
        anexo.tipo( alunoEntity.getTipo() );
        anexo.url( alunoEntity.getUrl() );
        anexo.uuid( alunoEntity.getUuid() );

        return anexo.build();
    }

    @Override
    public List<Anexo> toDomain(List<AnexoEntity> AnexoEtapaEntities) {
        if ( AnexoEtapaEntities == null ) {
            return null;
        }

        List<Anexo> list = new ArrayList<Anexo>( AnexoEtapaEntities.size() );
        for ( AnexoEntity anexoEntity : AnexoEtapaEntities ) {
            list.add( toDomain( anexoEntity ) );
        }

        return list;
    }

    @Override
    public List<AnexoEntity> toEntity(List<Anexo> Anexo) {
        if ( Anexo == null ) {
            return null;
        }

        List<AnexoEntity> list = new ArrayList<AnexoEntity>( Anexo.size() );
        for ( Anexo anexo : Anexo ) {
            list.add( toEntity( anexo ) );
        }

        return list;
    }
}
