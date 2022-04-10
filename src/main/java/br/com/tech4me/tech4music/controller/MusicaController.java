package br.com.tech4me.tech4music.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4me.tech4music.model.Musica;
import br.com.tech4me.tech4music.service.MusicaService;

@RestController
@RequestMapping("/api/musicas")
public class MusicaController {
    
    @Autowired
    private MusicaService service;

    @GetMapping
    public ResponseEntity<List<Musica>> obterMusicas() {
        return new ResponseEntity<>(service.obterTodas(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Musica> criarMusica(@RequestBody Musica musica) {
        return new ResponseEntity<>(service.criarMusica(musica), HttpStatus.CREATED);
    }

    @PutMapping(value="/{id}")
    public Musica atualizarPorId(@PathVariable String id, @RequestBody Musica musica) {
        return service.atualizarMusica(id, musica); 
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<String> removerMusica(@PathVariable String id) {
        service.removerMusica(id);
        return new ResponseEntity<>("Apagada com sucesso!", HttpStatus.OK);
    }

}
