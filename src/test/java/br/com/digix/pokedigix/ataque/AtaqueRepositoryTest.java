package br.com.digix.pokedigix.ataque;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.digix.pokedigix.tipo.Tipo;
import br.com.digix.pokedigix.tipo.TipoRepository;

@DataJpaTest
public class AtaqueRepositoryTest {

    @Autowired
    private AtaqueRepository ataqueRepository;

    @Autowired
    private TipoRepository tipoRepository;

    @Test
    public void deve_salvar_um_ataque() throws AcuraciaInvalidaException, ForcaInvalidaParaCategoriaException, TipoInvalidoParaCategoriaException {

        int forca = 10;
        int acuracia = 50;
        int pontosDePoder = 70;
        Categoria categoria = Categoria.FISICO;
        String nomeAtaque = "Choque de Trovão";
        String descricaoAtaque = "Um poderoso ataque de raio, com a força de um trovão";
        Tipo tipo = new Tipo("Normal");

        Ataque ataque = new Ataque(forca, acuracia, pontosDePoder, categoria, descricaoAtaque, nomeAtaque, tipo);

        ataqueRepository.save(ataque);

        assertNotNull(ataque.getId());
    }

    @Test
    public void deve_salvar_um_tipo_para_um_ataque() throws AcuraciaInvalidaException, ForcaInvalidaParaCategoriaException, TipoInvalidoParaCategoriaException {
        int forca = 10;
        int acuracia = 50;
        int pontosDePoder = 70;
        Categoria categoria = Categoria.FISICO;
        String nomeAtaque = "Choque de Trovão";
        String descricaoAtaque = "Um poderoso ataque de raio, com a força de um trovão";
        Tipo tipo = new Tipo("Normal");

        Ataque ataque = new Ataque(forca, acuracia, pontosDePoder, categoria, descricaoAtaque, nomeAtaque, tipo);
        tipoRepository.save(tipo);
        ataqueRepository.save(ataque);

        Ataque ataqueRetornado = ataqueRepository.findById(ataque.getId()).get();

        assertEquals(tipo.getNome(), ataqueRetornado.getTipo().getNome());
        assertNotNull(ataqueRetornado.getTipo().getId());
    }

    @Test
    public void deve_salvar_ataque_pelo_seu_tipo() throws AcuraciaInvalidaException, ForcaInvalidaParaCategoriaException, TipoInvalidoParaCategoriaException {
        int forca = 10;
        int acuracia = 50;
        int pontosDePoder = 70;
        Categoria categoria = Categoria.FISICO;
        String nomeAtaque = "Choque de Trovão";
        String descricaoAtaque = "Um poderoso ataque de raio, com a força de um trovão";
        Tipo tipo = new Tipo("Normal");

        Ataque ataque = new Ataque(forca, acuracia, pontosDePoder, categoria, descricaoAtaque, nomeAtaque, tipo);
        tipoRepository.save(tipo);
        ataqueRepository.save(ataque);

        Collection<Ataque> ataquesRetornados = ataqueRepository.findByTipo(tipo);

        assertTrue(ataquesRetornados.contains(ataque));
    }

    @Test
    public void deve_salvar_ataque_pela_categoria() throws AcuraciaInvalidaException, ForcaInvalidaParaCategoriaException, TipoInvalidoParaCategoriaException {
        int forca = 10;
        int acuracia = 50;
        int pontosDePoder = 70;
        Categoria categoria = Categoria.FISICO;
        String nomeAtaque = "Choque de Trovão";
        String descricaoAtaque = "Um poderoso ataque de raio, com a força de um trovão";
        Tipo tipo = new Tipo("Normal");

        Ataque ataque = new Ataque(forca, acuracia, pontosDePoder, categoria, descricaoAtaque, nomeAtaque, tipo);
        tipoRepository.save(tipo);
        ataqueRepository.save(ataque);

        Collection<Ataque> ataquesRetornados = ataqueRepository.findByCategoria(categoria);

        assertTrue(ataquesRetornados.contains(ataque));
    }

}
