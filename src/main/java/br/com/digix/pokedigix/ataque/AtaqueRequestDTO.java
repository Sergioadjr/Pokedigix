package br.com.digix.pokedigix.ataque;

import br.com.digix.pokedigix.tipo.Tipo;

public class AtaqueRequestDTO {
    
    private int acuracia;
    private Tipo tipo;
    private Categoria categoria_ataque;
    private int pontos_de_poder;
    private String nome_ataque;
    private String descricao_ataque;

    public int getAcuracia() {
        return acuracia;
    }
    public void setAcuracia(int acuracia) {
        this.acuracia = acuracia;
    }
    public int getPontos_de_poder() {
        return pontos_de_poder;
    }
    public void setPontos_de_poder(int pontos_de_poder) {
        this.pontos_de_poder = pontos_de_poder;
    }
    public Categoria getCategoria_ataque() {
        return categoria_ataque;
    }
    public void setCategoria_ataque(Categoria categoria_ataque) {
        this.categoria_ataque = categoria_ataque;
    }
    public String getDescricao_ataque() {
        return descricao_ataque;
    }
    public void setDescricao_ataque(String descricao_ataque) {
        this.descricao_ataque = descricao_ataque;
    }
    public String getNome_ataque() {
        return nome_ataque;
    }
    public void setNome_ataque(String nome_ataque) {
        this.nome_ataque = nome_ataque;
    }
    public Tipo getTipo() {
        return tipo;
    }
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    
}
