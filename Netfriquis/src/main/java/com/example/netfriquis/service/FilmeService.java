package com.example.netfriquis.service;

import com.example.netfriquis.model.Filme;
import com.example.netfriquis.model.Analise;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class FilmeService {

    private final Map<Long, Filme> filmes = new LinkedHashMap<>();
    private final AtomicLong filmeIdGen = new AtomicLong(1);
    private final AtomicLong analiseIdGen = new AtomicLong(1);

    public Filme salvarFilme(Filme filme) {
        if (filme.getId() == null) {
            filme.setId(filmeIdGen.getAndIncrement());
        }
        filmes.put(filme.getId(), filme);
        return filme;
    }

    public List<Filme> listarTodos() {
        return new ArrayList<>(filmes.values());
    }

    public Optional<Filme> buscarPorId(Long id) {
        return Optional.ofNullable(filmes.get(id));
    }

    public Analise adicionarAnalise(Long filmeId, Analise analise) {
        Filme filme = filmes.get(filmeId);
        if (filme == null) {
            throw new NoSuchElementException("Filme não encontrado: " + filmeId);
        }
        analise.setId(analiseIdGen.getAndIncrement());
        filme.adicionarAnalise(analise);
        return analise;
    }
}
