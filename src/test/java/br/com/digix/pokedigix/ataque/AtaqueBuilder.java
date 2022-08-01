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

    
    public AtaqueBuilder comTipo(Tipo tipo) {
        this.tipo = tipo;
        return this;
    }
    
    public AtaqueBuilder comAcuracia(int acuracia) {
        this.acuracia = acuracia;
        return this;
    }
    
    public AtaqueBuilder comCategoriaEfeito() {
        this.categoria = Categoria.EFEITO;
        return this;
    }


    public AtaqueBuilder comForca(int forca) {
        this.forca = forca;
        return this;
    }


    public AtaqueBuilder comCategoria(Categoria categoria) {
        this.categoria = categoria;
        return this;
    }
    
    public Ataque construir() throws AcuraciaInvalidaException, ForcaInvalidaParaCategoriaException, TipoInvalidoParaCategoriaException {
        if (this.categoria.equals(Categoria.EFEITO)) {
            return new Ataque(acuracia, pontosDePoder, descricaoAtaque, nomeAtaque);
        } else {
            return new Ataque(forca, acuracia, pontosDePoder, categoria, descricaoAtaque, nomeAtaque, tipo);
        }
  
    }



}
