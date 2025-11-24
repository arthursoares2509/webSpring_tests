package com.example.netfriquis.controller;

import com.example.netfriquis.model.Filme;
import com.example.netfriquis.model.Analise;
import com.example.netfriquis.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    // página inicial (index.html)
    @GetMapping("/index")
    public String index() {
        return "filmes/index"; // abre templates/filmes/index.html
    }

    // lista todos os filmes (list.html)
    @GetMapping
    public String listarFilmes(Model model) {
        model.addAttribute("filmes", filmeService.listarTodos());
        model.addAttribute("filme", new Filme()); // necessário para th:object no formulário
        return "filmes/list"; // abre templates/filmes/list.html
    }

    // salvar filme (POST /filmes)
    @PostMapping
    public String salvarFilme(@ModelAttribute Filme filme) {
        filmeService.salvarFilme(filme);
        return "redirect:/filmes"; // mantém funcionalidade de salvar
    }

    // detalhes do filme (detail.html)
    @GetMapping("/{id}")
    public String detalhesFilme(@PathVariable Long id, Model model) {
        Filme filme = filmeService.buscarPorId(id).orElse(null);
        if (filme == null) {
            return "redirect:/filmes"; // redireciona para a lista se não achar
        }
        model.addAttribute("filme", filme);
        model.addAttribute("analise", new Analise()); // necessário para th:object do formulário de análise
        return "filmes/detail"; // abre templates/filmes/detail.html
    }

    // adicionar análise (POST /filmes/{id}/analises)
    @PostMapping("/{id}/analises")
    public String adicionarAnalise(@PathVariable Long id, @ModelAttribute Analise analise) {
        filmeService.adicionarAnalise(id, analise);
        return "redirect:/filmes/" + id; // mantém funcionalidade
    }
}
