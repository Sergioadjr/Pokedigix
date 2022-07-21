package br.com.digix.pokedigix.pokemon;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pokemon {
    
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
Long id;

String nome; 
String tipo; 
String genero;
int nivel;
int felicidade;
double altura;
double peso;


public Pokemon (String nome, String tipo, String genero, int nivel, int felicidade, double altura, double peso) {
    this.nome = nome;
    this.tipo = tipo;
    this.genero = genero;
    this.nivel = nivel;
    this.felicidade = felicidade;
    this.altura = altura;
    this.peso = peso;
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
public String getTipo() {
    return this.tipo;
}
public void setTipo(String tipo) {
    this.tipo = tipo;
}
public String getGenero() {
    return this.genero;
}
public void setGenero(String genero) {
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

}
