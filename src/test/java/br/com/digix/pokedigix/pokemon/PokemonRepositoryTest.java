package br.com.digix.pokedigix.pokemon;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class PokemonRepositoryTest {

    
    
    @Autowired
    private PokemonRespository pokemonRepository; 

    @Test
    public void deve_salvar_um_pokemon () {
        
        String nome = "Pikachu"; 
        String tipo = "Elétrico"; 
        String genero = "Feminino";
        int nivel = 2;
        int felicidade = 8;
        double altura = 0.5;
        double peso = 1.2 ; 
        
        Pokemon pokemon = new Pokemon ( nome,  tipo, genero, nivel, felicidade, altura, peso);
    
   
        pokemonRepository.save(pokemon);

        assertNotNull(pokemon.getId());


    }
}
