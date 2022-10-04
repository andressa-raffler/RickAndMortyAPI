package com.example.rickandmortyapi.Repository;

import com.example.rickandmortyapi.model.RickAndMorty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RickAndMortyRepository extends JpaRepository<RickAndMorty, Long> {


    Optional<RickAndMorty> findByNome(String nome);


}
