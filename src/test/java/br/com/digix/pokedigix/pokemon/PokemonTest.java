package br.com.digix.pokedigix.pokemon;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
    public void deve_poder_criar_um_pokemon() throws AcuraciaInvalidaException, ForcaInvalidaParaCategoriaException,
            TipoInvalidoParaCategoriaException, NivelDoPokemonInvalidaException, FelicidadeDoPokemonInvalidaException {
        // Arrange
        Long id = 1L;
        String nome = "Pikachu";
        Genero genero = Genero.FEMININO;
        int nivel = 2;
        int felicidade = 8;
        double altura = 0.5;
        double peso = 1.2;
        int pokedex = 194;
        List<Tipo> tipos = new ArrayList<>();
        tipos.add(new Tipo("Elétrico"));
        List<Ataque> ataques = new ArrayList<>();
        ataques.add(new AtaqueBuilder().construir());

        // Act
        Pokemon pokemon = new Pokemon(nome, genero, nivel, felicidade, altura, peso, pokedex, tipos, ataques);

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
    public void deve_cadastrar_um_tipo_para_o_pokemon() throws NivelDoPokemonInvalidaException, FelicidadeDoPokemonInvalidaException {

        Tipo tipo = new Tipo("Elétrico");

        // Act
        Pokemon pokemon = new PokemonBuilder().comTipo(tipo).construir();

        assertTrue(pokemon.getTipos().contains(tipo));
    }

    @Test
    public void deve_ter_nivel_minimo_um() throws NivelDoPokemonInvalidaException, FelicidadeDoPokemonInvalidaException {
        int nivelMinimo = 1;
        Pokemon pokemon = new PokemonBuilder().comNivelMinimo(nivelMinimo).construir();
        assertEquals(nivelMinimo, pokemon.getNivel());
    }

    @Test
    public void deve_ter_nivel_maximo_cem() throws NivelDoPokemonInvalidaException, FelicidadeDoPokemonInvalidaException {
        int nivelMaximo = 100;
        Pokemon pokemon = new PokemonBuilder().comNivelMaximo(nivelMaximo).construir();
        assertEquals(nivelMaximo, pokemon.getNivel());
    }

    @Test
    public void nao_pode_ter_nivel_menor_que_um() {
        int nivelMinimo = 0;

        assertThrows(NivelDoPokemonInvalidaException.class, () -> {
            new PokemonBuilder().comNivelMinimo(nivelMinimo).construir();
        });
    }

    @Test
    public void nao_pode_ter_nivel_maior_que_cem() {
        int nivelMaximo = 101;

        assertThrows(NivelDoPokemonInvalidaException.class, () -> {
            new PokemonBuilder().comNivelMaximo(nivelMaximo).construir();
        });
    }

    @Test
    public void deve_ter_felicidade_minima_zero() throws Exception {
        int felicidadeMinima = 0;

        Pokemon pokemon = new PokemonBuilder().comFelicidade(felicidadeMinima).construir();

        assertEquals(felicidadeMinima, pokemon.getFelicidade());
    }

    @Test
    public void deve_ter_felicidade_maxima_zero() throws Exception {
        int felicidadeMaxima = 100;

        Pokemon pokemon = new PokemonBuilder().comFelicidade(felicidadeMaxima).construir();

        assertEquals(felicidadeMaxima, pokemon.getFelicidade());
    }

    @Test
    public void nao_pode_ter_felicidade_superior_a_cem() {
        int felicidadeMaxima = 101;

        assertThrows(FelicidadeDoPokemonInvalidaException.class, () -> {
            new PokemonBuilder().comFelicidade(felicidadeMaxima).construir();
        });
    }
    
    @Test
    public void nao_pode_ter_felicidade_inferior_a_zero() {
        int felicidadeMinima = -1;

        assertThrows(FelicidadeDoPokemonInvalidaException.class, () -> {
            new PokemonBuilder().comFelicidade(felicidadeMinima).construir();
        });
    }
}
