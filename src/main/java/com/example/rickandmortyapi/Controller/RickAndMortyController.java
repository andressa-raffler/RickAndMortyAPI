package com.example.rickandmortyapi.Controller;

import com.example.rickandmortyapi.Service.RickAndMortyService;
import com.example.rickandmortyapi.model.RickAndMorty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class RickAndMortyController {

    @Autowired
    RickAndMortyService rickAndMortyService;

    @PostMapping("/input-nome-aluno")
    public ResponseEntity<String> retornaPersonagem (@RequestBody String nome)  {
        RickAndMorty rickAndMorty = new RickAndMorty();
        rickAndMortyService.atualizarRickAndMorty(nome);
       return ResponseEntity.ok("criado");
    }

    @PostMapping("/gravar-personagem")
    public String criarAluno( @RequestBody String nome){
        RickAndMorty rickAndMorty = new RickAndMorty();
        rickAndMorty.setNome(nome);
        rickAndMortyService.atualizarRickAndMorty(nome);
        return "<h1> Personagem gravado </h1>";
    }
}
