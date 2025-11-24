package com.example.netfriquis.model;

import java.util.ArrayList;
import java.util.List;

public class Filme {
    private Long id;
    private String titulo;
    private String sinopse;
    private String genero;
    private Integer anoLancamento;
    private List<Analise> analises = new ArrayList<>();

    public Filme() {}

    public Filme(Long id, String titulo, String sinopse, String genero, Integer anoLancamento) {
        this.id = id;
        this.titulo = titulo;
        this.sinopse = sinopse;
        this.genero = genero;
        this.anoLancamento = anoLancamento;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getSinopse() { return sinopse; }
    public void setSinopse(String sinopse) { this.sinopse = sinopse; }
    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }
    public Integer getAnoLancamento() { return anoLancamento; }
    public void setAnoLancamento(Integer anoLancamento) { this.anoLancamento = anoLancamento; }
    public List<Analise> getAnalises() { return analises; }
    public void setAnalises(List<Analise> analises) { this.analises = analises; }

    public void adicionarAnalise(Analise a) { this.analises.add(a); }
}
