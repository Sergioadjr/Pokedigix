package br.com.digix.pokedigix.ataque;

public class TipoInvalidoParaCategoriaException extends Exception{
    public TipoInvalidoParaCategoriaException(){
        super("O tipo não deve deve ser vazio.");
    }
    
}
