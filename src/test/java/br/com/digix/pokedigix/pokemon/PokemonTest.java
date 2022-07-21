package br.com.digix.pokedigix.pokemon;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PokemonTest {
    @Test
    public void deve_poder_criar_um_pokemon(){
        // Arrange
        Long id = 1L;
        String nome = "Pikachu"; 
        String tipo = "Elétrico"; 
        String genero = "Feminino";
        int nivel = 2;
        int felicidade = 8;
        double altura = 0.5;
        double peso = 1.2 ;

        // Act
        Pokemon pokemon = new Pokemon (nome, tipo, genero, nivel, felicidade, altura, peso);
        
        // Assert  
        assertEquals(nome, pokemon.getNome());
        assertEquals(tipo, pokemon.getTipo());
        assertEquals(genero, pokemon.getGenero());
        assertEquals(nivel, pokemon.getNivel());
        assertEquals(felicidade, pokemon.getFelicidade());
        assertEquals(altura, pokemon.getAltura());
        assertEquals(peso, pokemon.getPeso());
    }    
}
