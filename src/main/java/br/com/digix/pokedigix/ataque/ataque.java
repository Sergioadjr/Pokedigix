package br.com.digix.pokedigix.ataque;

public class ataque {
int Forca;
int Acuracia;
int Pontos_de_poder;
String Categoria_ataque;
String Descricao_ataque;
String Nome_ataque;


// um ataque pode ter 3 categorias: ‘Fisico’, ‘Especial’ e ‘Efeito’;
// A acuracia vai de 0 a 100;
// Cada ataque deve ter um tipo;
// Se o ataque for da categoria ‘Efeito’, ele nao tem tipo e nao tem forca


public ataque(int forca, int acuracia, int pontos_de_poder, String categoria_ataque, String descricao_ataque,
        String nome_ataque) {
    Forca = forca;
    Acuracia = acuracia;
    Pontos_de_poder = pontos_de_poder;
    Categoria_ataque = categoria_ataque;
    Descricao_ataque = descricao_ataque;
    Nome_ataque = nome_ataque;

}
public int getForca() {
    return Forca;
}
public void setForca(int forca) {
    Forca = forca;
}
public int getAcuracia() {
    return Acuracia;
}
public void setAcuracia(int acuracia) {
    Acuracia = acuracia;
}
public int getPontos_de_poder() {
    return Pontos_de_poder;
}
public void setPontos_de_poder(int pontos_de_poder) {
    Pontos_de_poder = pontos_de_poder;
}
public String getCategoria_ataque() {
    return Categoria_ataque;
}
public void setCategoria_ataque(String categoria_ataque) {
    Categoria_ataque = categoria_ataque;
}
public String getDescricao_ataque() {
    return Descricao_ataque;
}
public void setDescricao_ataque(String descricao_ataque) {
    Descricao_ataque = descricao_ataque;
}
public String getNome_ataque() {
    return Nome_ataque;
}
public void setNome_ataque(String nome_ataque) {
    Nome_ataque = nome_ataque;
}

}
