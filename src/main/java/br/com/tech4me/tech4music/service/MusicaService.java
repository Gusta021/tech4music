package br.com.tech4me.tech4music.service;

import java.util.List;

import br.com.tech4me.tech4music.model.Musica;

public interface MusicaService {
    
    Musica criarMusica(Musica musica);
    List<Musica> obterTodas();
    Musica atualizarMusica(String id, Musica musica); 
    void removerMusica(String id);
    
}
