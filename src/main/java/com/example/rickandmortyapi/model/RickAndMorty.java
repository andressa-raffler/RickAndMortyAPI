package com.example.rickandmortyapi.model;


import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "RickAndMorty")
public class RickAndMorty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 100)
    private String personagem;


}
