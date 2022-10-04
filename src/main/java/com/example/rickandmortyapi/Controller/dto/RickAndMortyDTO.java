package com.example.rickandmortyapi.Controller.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RickAndMortyDTO {
    private String nome;
    private String personagem;
    //DTO - Transportar dos dados do VO
}
