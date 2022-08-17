package br.com.digix.pokedigix.ataque;

import br.com.digix.pokedigix.tipo.Tipo;
import br.com.digix.pokedigix.tipo.TipoResponseDTO;

public class AtaqueResponseDTO {
    private int acuracia;
    private TipoResponseDTO tipo;
    private Categoria categoria_ataque;
    private int pontos_de_poder;
    private String nome_ataque;
    private String descricao_ataque;
    private Long id;

    public AtaqueResponseDTO (Long id, String nome_ataque, String descricao_ataque, Categoria categoria_ataque,
            TipoResponseDTO tipo, int pontos_de_poder, int acuracia) {
        this.id = id;
        this.nome_ataque = nome_ataque;
        this.descricao_ataque = descricao_ataque;
        this.categoria_ataque = categoria_ataque;
        this.tipo = tipo;
        this.pontos_de_poder = pontos_de_poder;
        this.acuracia = acuracia;
    }

    public int getAcuracia() {
        return acuracia;
    }

    public void setAcuracia(int acuracia) {
        this.acuracia = acuracia;
    }

    public TipoResponseDTO getTipo() {
        return tipo;
    }

    public void setTipo(TipoResponseDTO tipo) {
        this.tipo = tipo;
    }

    public Categoria getCategoria_ataque() {
        return categoria_ataque;
    }

    public void setCategoria_ataque(Categoria categoria_ataque) {
        this.categoria_ataque = categoria_ataque;
    }

    public int getPontos_de_poder() {
        return pontos_de_poder;
    }

    public void setPontos_de_poder(int pontos_de_poder) {
        this.pontos_de_poder = pontos_de_poder;
    }

    public String getNome_ataque() {
        return nome_ataque;
    }

    public void setNome_ataque(String nome_ataque) {
        this.nome_ataque = nome_ataque;
    }

    public String getDescricao_ataque() {
        return descricao_ataque;
    }

    public void setDescricao_ataque(String descricao_ataque) {
        this.descricao_ataque = descricao_ataque;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
