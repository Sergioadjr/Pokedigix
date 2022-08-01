package br.com.digix.pokedigix.pokemon;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.digix.pokedigix.ataque.AcuraciaInvalidaException;
import br.com.digix.pokedigix.ataque.Ataque;
import br.com.digix.pokedigix.ataque.AtaqueBuilder;
import br.com.digix.pokedigix.ataque.ForcaInvalidaParaCategoriaException;
import br.com.digix.pokedigix.ataque.TipoInvalidoParaCategoriaException;
import br.com.digix.pokedigix.tipo.Tipo;

public class PokemonTest {
    @Test
    public void deve_poder_criar_um_pokemon() throws AcuraciaInvalidaException, ForcaInvalidaParaCategoriaException, TipoInvalidoParaCategoriaException{
        // Arrange
        Long id = 1L;
        String nome = "Pikachu"; 
        Genero genero = Genero.FEMININO;
        int nivel = 2;
        int felicidade = 8;
        double altura = 0.5;
        double peso = 1.2 ;
        int pokedex = 194;
        List <Tipo> tipos = new ArrayList<>();
        tipos.add(new Tipo("Elétrico"));
        List <Ataque> ataques = new ArrayList<>();
        ataques.add(new AtaqueBuilder().construir());
    

        // Act
        Pokemon pokemon = new Pokemon (nome, genero, nivel, felicidade, altura, peso, pokedex, tipos,ataques);
        
        // Assert  
        assertEquals(nome, pokemon.getNome());
        assertEquals(genero, pokemon.getGenero());
        assertEquals(nivel, pokemon.getNivel());
        assertEquals(felicidade, pokemon.getFelicidade());
        assertEquals(altura, pokemon.getAltura());
        assertEquals(peso, pokemon.getPeso());
        assertEquals(pokedex, pokemon.getPokedex());
    }   
    
    @Test
    public void deve_cadastrar_um_tipo_para_o_pokemon(){
       
        Tipo tipo = new Tipo("Elétrico");
       
    

        // Act
        Pokemon pokemon = new PokemonBuilder().comTipo(tipo).construir();
        
       assertTrue(pokemon.getTipos().contains(tipo));
    }
}
