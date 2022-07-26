package br.com.digix.pokedigix.ataque;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import br.com.digix.pokedigix.tipo.Tipo;

public class AtaqueTest {
        @Test
        public void deve_salvar_um_ataque(){
            // Arrange

            int forca = 10;
            int acuracia = 50;
            int pontosDePoder = 70;
            Categoria categoria = Categoria.FISICO;
            String nomeAtaque = "Choque de Trovão";
            Tipo tipo = new Tipo("normal");
            String descricaoAtaque = "Um poderoso ataque de raio, com a força de um trovão";

            // Act
            Ataque ataque = new Ataque( forca,  acuracia, pontosDePoder, categoria, descricaoAtaque, nomeAtaque, tipo);
        
            // Assert
            assertEquals(forca, ataque.getForca());
            assertEquals(acuracia, ataque.getAcuracia());
            assertEquals(pontosDePoder, ataque.getPontosDePoder());
            assertEquals(categoria, ataque.getCategoriaAtaque());
            assertEquals(descricaoAtaque, ataque.getDescricaoAtaque());
            assertEquals(nomeAtaque, ataque.getNomeAtaque());

        }   
        
        @Test
        public void deve_ser_obrigatorio_informar_um_tipo (){
           Tipo tipo = new Tipo ("normal");

            Ataque ataque = new AtaqueBuilder().comTipo(tipo).construir();

            assertEquals (tipo, ataque.getTipo());
        }
    }

