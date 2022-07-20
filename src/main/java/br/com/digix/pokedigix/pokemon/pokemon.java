package br.com.digix.pokedigix.pokemon;
public class pokemon {

String nome; 
String tipo; 
String genero;
int nivel;
int felicidade;
int altura;
int peso;

public pokemon(String nome, String tipo, String genero, int nivel, int felicidade, int altura, int peso) {
    this.nome = nome;
    this.tipo = tipo;
    this.genero = genero;
    this.nivel = nivel;
    this.felicidade = felicidade;
    this.altura = altura;
    this.peso = peso;
}

public String getNome() {
    return nome;
}

public void setNome(String nome) {
    this.nome = nome;
}

public String getTipo() {
    return tipo;
}

public void setTipo(String tipo) {
    this.tipo = tipo;
}

public String getGenero() {
    return genero;
}

public void setGenero(String genero) {
    this.genero = genero;
}

public int getNivel() {
    return nivel;
}

public void setNivel(int nivel) {
    this.nivel = nivel;
}

public int getFelicidade() {
    return felicidade;
}

public void setFelicidade(int felicidade) {
    this.felicidade = felicidade;
}

public int getAltura() {
    return altura;
}

public void setAltura(int altura) {
    this.altura = altura;
}

public int getPeso() {
    return peso;
}

public void setPeso(int peso) {
    this.peso = peso;
} 
}
