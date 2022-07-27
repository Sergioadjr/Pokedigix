package br.com.digix.pokedigix.personagem;

public class EnderecoBuilder {
    private String regiao;
    private String cidade;

    public EnderecoBuilder() {
        this.regiao = "kanto";
        this.cidade = "Pallet";
    }

    public Endereco construir() {
        return new Endereco(regiao, cidade);
    }

    
}
