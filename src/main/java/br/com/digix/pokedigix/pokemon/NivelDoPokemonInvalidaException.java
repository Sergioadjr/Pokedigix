package br.com.digix.pokedigix.pokemon;

public class NivelDoPokemonInvalidaException extends Exception {
    
        public NivelDoPokemonInvalidaException (){
            super ("Um pokem precisa de nível mínimo de 1 e nível máximo de 100.");
        }


}
