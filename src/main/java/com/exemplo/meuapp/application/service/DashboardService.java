package com.exemplo.meuapp.application.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemplo.meuapp.domain.model.Projeto;
import com.exemplo.meuapp.infrastructure.persistence.repository.ProjetoRepository;
import com.exemplo.meuapp.presentation.dto.RoleSpecificDTO.ProjetoPublicoDTO;

/**
 * Service para gerenciar os dashboards e estatísticas públicas
 */
@Service
public class DashboardService {

    @Autowired
    private ProjetoRepository projetoRepository;

    /**
     * Busca todos os projetos públicos do sistema
     * @return Mapa com projetos e estatísticas
     */
    public Map<String, Object> getPublicProjects() {
        // Busca todos os projetos do banco de dados
        List<Projeto> todosProjetos = projetoRepository.getAllProjetos();
        
        // Converte para DTO público
        List<ProjetoPublicoDTO> projetosPublicos = todosProjetos.stream()
            .map(this::converterParaProjetoPublico)
            .collect(Collectors.toList());
        
        // Extrai tecnologias únicas (baseado no curso)
        Set<String> tecnologias = todosProjetos.stream()
            .map(Projeto::getCurso)
            .filter(Objects::nonNull)
            .collect(Collectors.toSet());
        
        // Extrai categorias únicas (baseado em características dos projetos)
        Set<String> categorias = extrairCategorias(todosProjetos);
        
        return Map.of(
            "projetos", projetosPublicos,
            "total", projetosPublicos.size(),
            "categorias", new ArrayList<>(categorias),
            "tecnologiasMaisUsadas", new ArrayList<>(tecnologias),
            "ultimaAtualizacao", LocalDateTime.now()
        );
    }

    /**
     * Converte um Projeto do domínio para ProjetoPublicoDTO
     */
    private ProjetoPublicoDTO converterParaProjetoPublico(Projeto projeto) {
        // Nome do autor (líder do projeto)
        String autorNome = "Não informado";
        if (projeto.getLiderProjeto() != null && 
            projeto.getLiderProjeto().getUsuarios() != null &&
            projeto.getLiderProjeto().getUsuarios().getUsuario() != null) {
            autorNome = projeto.getLiderProjeto().getUsuarios().getUsuario();
        }
        
        // Tecnologias (curso e unidade curricular)
        List<String> tecnologias = new ArrayList<>();
        if (projeto.getCurso() != null) {
            tecnologias.add(projeto.getCurso());
        }
        if (projeto.getUnidadeCurricular() != null && 
            projeto.getUnidadeCurricular().getNome() != null) {
            tecnologias.add(projeto.getUnidadeCurricular().getNome());
        }
        
        // Status formatado
        String status = projeto.getStatus() != null ? 
            formatarStatus(projeto.getStatus().toString()) : "Em Desenvolvimento";
        
        // Data de publicação (usa criadoEm ou atualizadoEm)
        LocalDateTime publicadoEm = projeto.getAtualizadoEm() != null ? 
            projeto.getAtualizadoEm() : 
            (projeto.getCriadoEm() != null ? projeto.getCriadoEm() : LocalDateTime.now());
        
        // Visualizações (mock - pode ser implementado depois)
        Long visualizacoes = calcularVisualizacoes(projeto);
        
        return new ProjetoPublicoDTO(
            projeto.getUuid() != null ? projeto.getUuid().toString() : UUID.randomUUID().toString(),
            projeto.getTitulo() != null ? projeto.getTitulo() : "Projeto sem título",
            projeto.getDescricao() != null ? projeto.getDescricao() : "Sem descrição",
            autorNome,
            tecnologias,
            status,
            publicadoEm,
            visualizacoes
        );
    }

    /**
     * Formata o status do projeto para exibição
     */
    private String formatarStatus(String status) {
        if (status == null) return "Em Desenvolvimento";
        
        return switch (status) {
            case "ATIVO" -> "Em Desenvolvimento";
            case "CONCLUIDO" -> "Publicado";
            case "INATIVO" -> "Inativo";
            case "CANCELADO" -> "Cancelado";
            default -> status;
        };
    }

    /**
     * Calcula visualizações baseado em características do projeto
     * (Implementação mock - pode ser substituída por contador real)
     */
    private Long calcularVisualizacoes(Projeto projeto) {
        // Gera um número baseado no UUID para ter consistência
        if (projeto.getUuid() != null) {
            return (long) (Math.abs(projeto.getUuid().hashCode()) % 500);
        }
        return 0L;
    }

    /**
     * Extrai categorias baseadas nas características dos projetos
     */
    private Set<String> extrairCategorias(List<Projeto> projetos) {
        Set<String> categorias = new HashSet<>();
        
        for (Projeto p : projetos) {
            // Adiciona categoria baseada em palavras-chave na descrição ou título
            if (p.getTitulo() != null) {
                String titulo = p.getTitulo().toLowerCase();
                if (titulo.contains("web") || titulo.contains("site")) {
                    categorias.add("Web");
                }
                if (titulo.contains("mobile") || titulo.contains("app")) {
                    categorias.add("Mobile");
                }
                if (titulo.contains("iot") || titulo.contains("sensor")) {
                    categorias.add("IoT");
                }
                if (titulo.contains("ecommerce") || titulo.contains("loja") || titulo.contains("vendas")) {
                    categorias.add("E-commerce");
                }
                if (titulo.contains("jogo") || titulo.contains("game")) {
                    categorias.add("Games");
                }
            }
            
            // Adiciona categoria baseada em flags especiais
            if (p.isLabMaker()) {
                categorias.add("Lab Maker");
            }
            if (p.isParticipouSaga()) {
                categorias.add("SAGA");
            }
        }
        
        // Se não encontrou nenhuma categoria, adiciona uma padrão
        if (categorias.isEmpty()) {
            categorias.add("Geral");
        }
        
        return categorias;
    }
}
