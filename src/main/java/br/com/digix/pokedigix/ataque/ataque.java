package br.com.digix.pokedigix.ataque;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import br.com.digix.pokedigix.tipo.Tipo;

@Entity
public class Ataque {

@Id@GeneratedValue (strategy = GenerationType.AUTO)
private Long id;

@Column (nullable = false)
private int forca;

@Column (nullable = false)
private int acuracia;

@Column (nullable = false)
private int pontos_de_poder;

@Column (nullable = false)
@Enumerated(EnumType.STRING)
private Categoria categoria;

@Column (nullable = false)
private String descricao_ataque;

@Column (nullable = false)
private String nome_ataque;

@ManyToOne
private Tipo tipo;

public Ataque(int forca, 
int acuracia, int pontos_de_poder, 
        Categoria categoria_ataque, 
        String descricao_ataque,
        String nome_ataque,
        Tipo tipo) {
    this.forca = forca;
    this.acuracia = acuracia;
    this.pontos_de_poder = pontos_de_poder;
    this.categoria = categoria_ataque;
    this.descricao_ataque = descricao_ataque;
    this.nome_ataque = nome_ataque;
    this.tipo=tipo;
}

public Tipo getTipo() {
    return this.tipo;
}

public int getForca() {
    return this.forca;
}
public void setForca(int forca) {
    this.forca = forca;
}
public int getAcuracia() {
    return this.acuracia;
}
public void setAcuracia(int acuracia) {
    this.acuracia = acuracia;
}
public int getPontosDePoder() {
    return this.pontos_de_poder;
}
public void setPontosDePoder(int pontos_de_poder) {
    this.pontos_de_poder = pontos_de_poder;
}
public Categoria getCategoriaAtaque() {
    return this.categoria;
}
public void setCategoriaAtaque(Categoria categoria_ataque) {
    this.categoria = categoria_ataque;
}
public String getDescricaoAtaque() {
    return this.descricao_ataque;
}
public void setDescricaoAtaque(String descricao_ataque) {
   this.descricao_ataque = descricao_ataque;
}
public String getNomeAtaque() {
    return this.nome_ataque;
}
public void setNomeAtaque(String nome_ataque) {
    this.nome_ataque = nome_ataque;
}

public Long getId() {
    return this.id;
}


// um ataque pode ter 3 categorias: ‘Fisico’, ‘Especial’ e ‘Efeito’;
// A acuracia vai de 0 a 100;
// Cada ataque deve ter um tipo;
// Se o ataque for da categoria ‘Efeito’, ele nao tem tipo e nao tem forca


}
