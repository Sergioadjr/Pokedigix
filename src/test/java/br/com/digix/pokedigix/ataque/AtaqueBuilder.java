package br.com.digix.pokedigix.ataque;

import br.com.digix.pokedigix.tipo.Tipo;

public class AtaqueBuilder {

    private int forca;
    private int acuracia;
    private int pontosDePoder;
    private Categoria categoria;
    private String nomeAtaque;
    private Tipo tipo;
    private String descricaoAtaque;

    public AtaqueBuilder (){
        this.forca = 10;
        this.acuracia = 50;
        this.pontosDePoder = 70;
        this.categoria = Categoria.FISICO;
        this.nomeAtaque = "Choque de Trovão";
        this.tipo = new Tipo("normal");
        this.descricaoAtaque = "Um poderoso ataque de raio, com a força de um trovão";
    }

    public Ataque construir() {
        return new Ataque(forca, acuracia, pontosDePoder, categoria, descricaoAtaque, nomeAtaque, tipo);
    }

    public AtaqueBuilder comTipo(Tipo tipo2) {
        tipo = tipo2;
        return this;
    }
    
}
