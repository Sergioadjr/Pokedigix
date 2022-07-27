package br.com.digix.pokedigix.personagem;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;

import br.com.digix.pokedigix.pokemon.Pokemon;

@Entity
public class Lider extends Personagem{

    @Enumerated
    @Column(nullable = false)
    private Insignia insignia;   
    
    public Lider(String nome, Endereco endereco, Collection<Pokemon>pokemons) {
        super(nome, endereco);
        super.pokemons = pokemons;
        this.insignia = insignia;
    }
    
}
