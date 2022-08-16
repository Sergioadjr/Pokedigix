package br.com.digix.pokedigix.personagem;

import br.com.digix.pokedigix.pokemon.FelicidadeDoPokemonInvalidaException;
import br.com.digix.pokedigix.pokemon.NivelDoPokemonInvalidaException;
import br.com.digix.pokedigix.pokemon.Pokemon;
import br.com.digix.pokedigix.pokemon.PokemonBuilder;

public class TreinadorBuilder {

    private String nome;
    private Endereco endereco;
    private Pokemon pokemon;

    public TreinadorBuilder() throws NivelDoPokemonInvalidaException, FelicidadeDoPokemonInvalidaException {
        this.nome = "Sergio";
        this.endereco = new EnderecoBuilder().construir();
        this.pokemon = new PokemonBuilder().construir();

    }

    public Treinador construir() throws LimiteDePokemonException {
        return new Treinador(nome, endereco, pokemon);
    }

    public TreinadorBuilder comPokemonInicial(Pokemon pokemonInicial) {
        this.pokemon = pokemonInicial;
        return this;
    }
    

}
