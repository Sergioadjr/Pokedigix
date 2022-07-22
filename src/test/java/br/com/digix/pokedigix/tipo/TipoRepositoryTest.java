package br.com.digix.pokedigix.tipo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class TipoRepositoryTest {
    
    @Autowired
    private TipoRepository tipoRepository;

    @Test
    public void deve_salvar_um_tipo () {
        
        // Arrenge
        String nomeEsperado = "Fantasma";
        Tipo tipo = new Tipo (nomeEsperado);

        // Act
        tipoRepository.save(tipo);
        
        // Assert
        assertNotNull(tipo.getId());
    }

    @Test
    public void deve_buscar_um_yipo_pelo_nome () {
        String nome = "Eletrico";
        Tipo tipo = new Tipo (nome);
        tipoRepository.save(tipo);

        Collection<Tipo> tiposRetornados = tipoRepository.findByNome(nome);
        assertTrue(tiposRetornados.contains(tipo));
    }
}
