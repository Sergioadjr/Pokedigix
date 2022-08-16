package br.com.digix.pokedigix.pokemon;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.ManyToAny;

import br.com.digix.pokedigix.ataque.Ataque;
import br.com.digix.pokedigix.tipo.Tipo;

@Entity
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 15, nullable = false)
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(length = 10, nullable = false)
    private Genero genero;

    @Column(nullable = false)
    private int nivel;

    @Column(nullable = false)
    private int pokedex;

    @Column(nullable = false)
    private int felicidade;

    @Column(nullable = false)
    private double altura;

    @Column(nullable = false)
    private double peso;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "pokemon_tipo", joinColumns = @JoinColumn(name = "pokemon_id"), inverseJoinColumns = @JoinColumn(name = "tipo_id"))
    private Collection<Tipo> tipos;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "pokemon_ataque", joinColumns = @JoinColumn(name = "pokemon_id"), inverseJoinColumns = @JoinColumn(name = "ataque_id"))
    private Collection<Ataque> ataques;

    public Pokemon(String nome, Genero genero, int nivel, int felicidade, double altura, double peso, int pokedex,
            Collection<Tipo> tipos, Collection<Ataque> ataques) throws NivelDoPokemonInvalidaException, FelicidadeDoPokemonInvalidaException {
        
        validarNivelDoPokemon(nivel);
        validarFelicidadeDoPokemon(felicidade);
        this.nome = nome;
        this.genero = genero;
        this.nivel = nivel;
        this.felicidade = felicidade;
        this.altura = altura;
        this.peso = peso;
        this.pokedex = pokedex;
        this.tipos = tipos;
        this.ataques = ataques;
    }

    
    private void validarFelicidadeDoPokemon(int felicidade) throws FelicidadeDoPokemonInvalidaException {
        if (felicidade < 0 || felicidade > 100 ) {
            throw new FelicidadeDoPokemonInvalidaException();         
        }
    }


    private void validarNivelDoPokemon (int nivel) throws NivelDoPokemonInvalidaException  {
        if (nivel < 1 || nivel > 100) {
            throw new NivelDoPokemonInvalidaException();
        }
    }

    public Long getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Genero getGenero() {
        return this.genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public int getNivel() {
        return this.nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getFelicidade() {
        return this.felicidade;
    }

    public void setFelicidade(int felicidade) {
        this.felicidade = felicidade;
    }

    public double getAltura() {
        return this.altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return this.peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getPokedex() {
        return pokedex;
    }

    public void setPokedex(int pokedex) {
        this.pokedex = pokedex;
    }

    public Collection<Tipo> getTipos() {
        return tipos;
    }

    public Collection<Ataque> getAtaques() {
        return ataques;
    }

}
