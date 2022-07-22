package br.com.digix.pokedigix.treinador;

public class Treinador {
    String nome_treinador;
    int dinheiro_treinador;
    int nivel_treinador;
    String pokemon;
    
    public Treinador(String nome_treinador, int dinheiro_treinador, int nivel_treinador, String pokemon) {
        this.nome_treinador = nome_treinador;
        this.dinheiro_treinador = dinheiro_treinador;
        this.nivel_treinador = nivel_treinador;
        this.pokemon = pokemon;
        
    }
    public String getNome_treinador() {
        return nome_treinador;
    }
    public void setNome_treinador(String nome_treinador) {
        this.nome_treinador = nome_treinador;
    }
    public int getDinheiro_treinador() {
        return dinheiro_treinador;
    }
    public void setDinheiro_treinador(int dinheiro_treinador) {
        this.dinheiro_treinador = dinheiro_treinador;
    }
    public int getNivel_treinador() {
        return nivel_treinador;
    }
    public void setNivel_treinador(int nivel_treinador) {
        this.nivel_treinador = nivel_treinador;
    }
    public String getPokemon() {
        return pokemon;
    }
    public void setPokemon(String pokemon) {
        this.pokemon = pokemon;
    }

}