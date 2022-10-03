package com.example.rickandmortyapi.Service;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Random;


@Service
public class RickAndMortyService {

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
        int numeroPagina = r.nextInt(42); //42 páginas disponiveis na minha API
        return "https://rickandmortyapi.com/api/character/?page="+numeroPagina;
    }
}
