package br.com.digix.pokedigix.pokemon;

import java.util.ArrayList;
import java.util.Collection;

import br.com.digix.pokedigix.ataque.Ataque;
import br.com.digix.pokedigix.ataque.AtaqueBuilder;
import br.com.digix.pokedigix.tipo.Tipo;

public class PokemonBuilder {
    private Collection<Ataque> ataques;
    private String nome;
    private int nivel;
    private Genero genero;
    private int felicidade;
    private double altura;
    private double peso;
    private int pokedex;
    private Collection<Tipo> tipos;

    public PokemonBuilder () {
        this.nome = "Pikachu"; 
        this.genero = Genero.FEMININO;
        this.nivel = 2;
        this.felicidade = 8;
        this.altura = 0.5;
        this.peso = 1.2 ;
        this.pokedex = 194;
        this.tipos = new ArrayList<>();
        this.ataques = new ArrayList<>();
        
    }

    public Pokemon construir() {
        return new Pokemon (nome, genero, nivel, felicidade, altura, peso, pokedex, tipos, ataques);
    }

    public PokemonBuilder comTipo (Tipo tipo) {
        tipos.add(tipo);
        return this;
    }
    
    public  PokemonBuilder comAtaque(Ataque ataque) {
        ataques.add(ataque);
        return this;
    }



    
}
