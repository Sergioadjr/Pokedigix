package br.com.digix.pokedigix.ataque;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import br.com.digix.pokedigix.pokemon.Pokemon;
import br.com.digix.pokedigix.tipo.Tipo;

@Entity
public class Ataque {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private int forca;

    @Column(nullable = false)
    private int acuracia;

    @Column(nullable = false)
    private int pontos_de_poder;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @Column(nullable = false)
    private String descricao_ataque;

    @Column(nullable = false)
    private String nome_ataque;

    @ManyToOne
    private Tipo tipo;

    @ManyToMany(mappedBy = "ataques")
    private Collection<Pokemon> pokemons;

    protected Ataque () {}
    
    public Ataque(int forca,
            int acuracia,
            int pontos_de_poder,
            Categoria categoria_ataque,
            String descricao_ataque,
            String nome_ataque,
            Tipo tipo)
            throws AcuraciaInvalidaException, ForcaInvalidaParaCategoriaException, TipoInvalidoParaCategoriaException {

        this.forca = forca;
        this.acuracia = acuracia;
        this.pontos_de_poder = pontos_de_poder;
        this.categoria = categoria_ataque;
        this.descricao_ataque = descricao_ataque;
        this.nome_ataque = nome_ataque;
        this.tipo = tipo;

        validarAcuracia(acuracia);
        validarForca(categoria, forca);
        validarTipo(categoria, tipo);
    }

    private void validarTipo(Categoria categoria, Tipo tipo) throws TipoInvalidoParaCategoriaException {
        if ((categoria.equals(Categoria.FISICO) || categoria.equals(Categoria.ESPECIAL)) && tipo == null) {
            throw new TipoInvalidoParaCategoriaException();
        }
    }

    private void validarForca(Categoria categoria, int forca) throws ForcaInvalidaParaCategoriaException {
        if ((categoria.equals(Categoria.FISICO)|| categoria.equals(Categoria.ESPECIAL))  && forca <= 0) {
            throw new ForcaInvalidaParaCategoriaException(categoria);
        }
    }

    private void validarAcuracia(int acuracia) throws AcuraciaInvalidaException {
        if (acuracia < 0 || acuracia > 100) {
            throw new AcuraciaInvalidaException();
        }
    }

    public Ataque(int acuracia, int pontos_de_poder, String descricao_ataque, String nome_ataque)
            throws AcuraciaInvalidaException {
        validarAcuracia(acuracia);
        this.acuracia = acuracia;
        this.pontos_de_poder = pontos_de_poder;
        this.descricao_ataque = descricao_ataque;
        this.nome_ataque = nome_ataque;
        this.categoria = Categoria.EFEITO;

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
