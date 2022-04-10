package br.com.tech4me.tech4music.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.tech4music.model.Musica;
import br.com.tech4me.tech4music.repository.MusicaRepository;

@Service
public class MusicaServiceImpl implements MusicaService {

    @Autowired
    private MusicaRepository repositorio;

    @Override
    public Musica criarMusica(Musica musica) {
        return repositorio.save(musica); 
    }

    @Override
    public List<Musica> obterTodas() {
        return repositorio.findAll();
    }

    @Override
    public Musica atualizarMusica(String id, Musica musica) {
        musica.setId(id);
        return repositorio.save(musica); 
    }

    @Override
    public void removerMusica(String id) {
        repositorio.deleteById(id); 
    }
    
}
