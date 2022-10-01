package com.example.rickandmortyapi.Service;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Objects;
import java.util.Random;
import java.util.random.RandomGenerator;

@Service
public class RickAndMortyService {

    public String getPersonagemPorNomeAluno(String nome){
        Random r = new Random();
        Integer numeroPagina = r.nextInt(42);
        //WebClient webClient = new WebClient();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<PersonagemDTO> retorno = restTemplate.getForEntity
                ("https://rickandmortyapi.com/api/character/?page={numeroPagina}",
                PersonagemDTO.class);

        Random r2 = new Random();
        return retorno.getBody().getResults().get(r2.nextInt(retorno.getBody().getResults().size())).getName();
    }
  //  @RequestMapping(value = {"/listaDecrescente"})
   // public int[] listaDecrescente(@RequestParam int[] lista){
//    @GetMapping("/cliente/{id}")
//    public ResponseEntity<ClienteDTO> buscarClientePorId(@PathVariable("id") Long id) {

    public int getPagina(){
        Random numeroPagina = new Random();
        return numeroPagina.nextInt(42);
    }
}
