package br.com.digix.pokedigix.pokemon;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.digix.pokedigix.ataque.Ataque;
import br.com.digix.pokedigix.ataque.AtaqueBuilder;
import br.com.digix.pokedigix.tipo.Tipo;

@DataJpaTest
public class PokemonRepositoryTest {

    @Autowired
    private PokemonRespository pokemonRepository;

    @Test
    public void deve_salvar_um_pokemon() {
        Tipo eletrico = new Tipo("Elétrico");
        Ataque ataque = new AtaqueBuilder().construir();
        Pokemon pokemon = new PokemonBuilder().comAtaque(ataque).comTipo(eletrico).construir();

        pokemonRepository.save(pokemon);

        assertNotNull(pokemon.getId());
    }

    @Test
    public void deve_salvar_um_pokemon_com_tipo() {
        int quantidadeDeTiposEsperada = 1;
        Tipo eletrico = new Tipo("Elétrico");
        Pokemon pikachu = new PokemonBuilder().comTipo(eletrico).construir();
        pokemonRepository.save(pikachu);

        Pokemon pikachuRetornado = pokemonRepository.findById(pikachu.getId()).get();

        assertNotNull(pikachuRetornado.getTipos());
        assertEquals(quantidadeDeTiposEsperada, pikachuRetornado.getTipos().size());
        assertTrue(pikachuRetornado.getTipos().contains(eletrico));
    }

    @Test
    public void deve_salvar_um_pokemon_com_ataque() {
        Ataque ataque = new AtaqueBuilder().construir();
        Pokemon pokemon = new PokemonBuilder().comAtaque(ataque).construir();

        pokemonRepository.save(pokemon);
        assertTrue(pokemon.getAtaques().contains(ataque));
    }

}
