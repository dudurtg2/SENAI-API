package com.exemplo.meuapp.presentation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Web Controller for serving frontend pages
 * Handles all web page routes and renders Thymeleaf templates
 */
@Controller
@RequestMapping("/")
public class WebController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("pageTitle", "Início");
        model.addAttribute("pageDescription", "Plataforma web educacional do SENAI para cadastro, gerenciamento e compartilhamento de projetos acadêmicos");
        model.addAttribute("activePage", "home");
        return "pages/home";
    }

    @GetMapping("/sobre")
    public String sobre(Model model) {
        model.addAttribute("pageTitle", "Sobre Nós");
        model.addAttribute("pageDescription", "Conheça a SENAI API - nossa missão, visão e como estamos transformando a educação através da tecnologia");
        model.addAttribute("activePage", "sobre");
        return "pages/sobre";
    }

    @GetMapping("/projetos")
    public String projetos(Model model) {
        model.addAttribute("pageTitle", "Projetos");
        model.addAttribute("pageDescription", "Explore os projetos acadêmicos desenvolvidos pelos alunos do SENAI e descubra inovações incríveis");
        model.addAttribute("activePage", "projetos");
        return "pages/projetos";
    }

    @GetMapping("/cursos")
    public String cursos(Model model) {
        model.addAttribute("pageTitle", "Cursos");
        model.addAttribute("pageDescription", "Conheça os cursos oferecidos pelo SENAI - formação técnica e superior de excelência");
        model.addAttribute("activePage", "cursos");
        return "pages/cursos";
    }

    @GetMapping("/contato")
    public String contato(Model model) {
        model.addAttribute("pageTitle", "Contato");
        model.addAttribute("pageDescription", "Entre em contato conosco - tire suas dúvidas e saiba como participar da plataforma SENAI API");
        model.addAttribute("activePage", "contato");
        return "pages/contato";
    }
}