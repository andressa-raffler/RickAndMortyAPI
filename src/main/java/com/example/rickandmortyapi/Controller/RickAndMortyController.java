package com.example.rickandmortyapi.Controller;

import com.example.rickandmortyapi.Service.RickAndMortyService;
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
       String personagem = rickAndMortyService.getPersonagemPorNomeAluno(nome);
       return ResponseEntity.ok(personagem);
    }
}
