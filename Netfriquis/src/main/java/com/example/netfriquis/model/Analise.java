package com.example.netfriquis.model;

public class Analise {
    private Long id;
    private String texto;
    private Integer nota;

    public Analise() {}

    public Analise(Long id, String texto, Integer nota) {
        this.id = id;
        this.texto = texto;
        this.nota = nota;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTexto() { return texto; }
    public void setTexto(String texto) { this.texto = texto; }
    public Integer getNota() { return nota; }
    public void setNota(Integer nota) { this.nota = nota; }
}
