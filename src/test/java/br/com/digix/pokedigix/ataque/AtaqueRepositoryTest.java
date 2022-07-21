package br.com.digix.pokedigix.ataque;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class AtaqueRepositoryTest {
    
    @Autowired
    private AtaqueRepository ataqueRepository;

    @Test
    public void deve_salvar_um_ataque () {
        
        int forca = 10;
            int acuracia = 50;
            int pontosDePoder = 70;
            Categoria categoria = Categoria.FISICO;
            String nomeAtaque = "Choque de Trovão";
            String descricaoAtaque = "Um poderoso ataque de raio, com a força de um trovão";

            long idEsperado = 1L;
            Ataque ataque = new Ataque( forca,  acuracia, pontosDePoder, categoria, descricaoAtaque, nomeAtaque);
    
   
        ataqueRepository.save(ataque);

        assertEquals(idEsperado, ataque.getId());


    }
}
