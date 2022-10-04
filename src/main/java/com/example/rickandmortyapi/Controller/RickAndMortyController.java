package com.example.rickandmortyapi.Controller;

import com.example.rickandmortyapi.Controller.vo.RickAndMortyVO;
import com.example.rickandmortyapi.Repository.RickAndMortyRepository;
import com.example.rickandmortyapi.Service.RickAndMortyService;
import com.example.rickandmortyapi.model.RickAndMorty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Controller
public class RickAndMortyController {

    @Autowired
    RickAndMortyService rickAndMortyService;

    @PostMapping("/input-nome-aluno")
    public ResponseEntity<String> retornaPersonagem (@RequestBody String nome)  {
        RickAndMorty rickAndMorty = new RickAndMorty();
        rickAndMorty.setNome(nome);
        rickAndMortyService.gravarPersonagem(nome);
       return ResponseEntity.ok("criado");
    }

    @PostMapping("/gravar-personagem")
    public String criarAluno( @RequestBody String nome){
        RickAndMorty rickAndMorty = new RickAndMorty();
        rickAndMorty.setNome(nome);
        rickAndMortyService.gravarPersonagem(nome);
        return "<h1> Personagem gravado </h1>";
    }
}
