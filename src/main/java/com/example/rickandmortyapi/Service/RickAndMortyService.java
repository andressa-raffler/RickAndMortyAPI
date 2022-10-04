package com.example.rickandmortyapi.Service;


import com.example.rickandmortyapi.Controller.dto.PersonagemDTO;
import com.example.rickandmortyapi.Repository.RickAndMortyRepository;
import com.example.rickandmortyapi.model.RickAndMorty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;
import java.util.Random;


@Service
public class RickAndMortyService {

        @Autowired
        private RickAndMortyRepository rickAndMortyRepository;
    public String getPersonagemPorNomeAluno(String nome){
        //WebClient webClient = new WebClient();
        String urlPagina = getUrlPagina();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<PersonagemDTO> retorno = restTemplate.getForEntity(urlPagina, PersonagemDTO.class);
        Random r2 = new Random();
        return retorno.getBody().getResults().get(r2.nextInt(retorno.getBody().getResults().size())).getName();
    }
    public String getUrlPagina(){
        Random r = new Random();
        int numeroPagina = r.nextInt(42); //42 páginas disponiveis na minha API - implementar p/ paginas variaveis - pages - DTO
        return "https://rickandmortyapi.com/api/character/?page="+numeroPagina;
    }

    public RickAndMorty criarRickAndMorty (RickAndMorty rickAndMorty) {
        return this.rickAndMortyRepository.save(rickAndMorty);
    }

    public RickAndMorty gravarPersonagem(String nome){
       String personagem = getPersonagemPorNomeAluno(nome);
        Optional<RickAndMorty> optionalRickAndMorty = this.rickAndMortyRepository.findByNome(nome);
        if(optionalRickAndMorty.isPresent()){
            RickAndMorty rickAndMorty = optionalRickAndMorty.get();
            RickAndMorty rickAndMortyAtualizado = new RickAndMorty();
            rickAndMortyAtualizado.setId(rickAndMorty.getId());
            rickAndMortyAtualizado.setNome(rickAndMortyAtualizado.getNome());
            rickAndMortyAtualizado.setPersonagem(personagem);
           return this.rickAndMortyRepository.save(rickAndMortyAtualizado); //devolve a própria entidade atualizada
        }
        return null;
    }


}
