package br.com.digix.pokedigix.pokemon;

public class FelicidadeDoPokemonInvalidaException extends Exception {
        public FelicidadeDoPokemonInvalidaException (){
            super ("Um pokem precisa de felicidade mínima de 0 e felicidade máxima de 100.");
        }
}
