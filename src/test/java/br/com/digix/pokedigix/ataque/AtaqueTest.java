package br.com.digix.pokedigix.ataque;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import br.com.digix.pokedigix.tipo.Tipo;

public class AtaqueTest {
    @Test
    public void deve_salvar_um_ataque() throws AcuraciaInvalidaException, ForcaInvalidaParaCategoriaException, TipoInvalidoParaCategoriaException {
        // Arrange

        int forca = 10;
        int acuracia = 50;
        int pontosDePoder = 70;
        Categoria categoria = Categoria.FISICO;
        String nomeAtaque = "Choque de Trovão";
        Tipo tipo = new Tipo("normal");
        String descricaoAtaque = "Um poderoso ataque de raio, com a força de um trovão";

        // Act
        Ataque ataque = new Ataque(forca, acuracia, pontosDePoder, categoria, descricaoAtaque, nomeAtaque, tipo);

        // Assert
        assertEquals(forca, ataque.getForca());
        assertEquals(acuracia, ataque.getAcuracia());
        assertEquals(pontosDePoder, ataque.getPontosDePoder());
        assertEquals(categoria, ataque.getCategoriaAtaque());
        assertEquals(descricaoAtaque, ataque.getDescricaoAtaque());
        assertEquals(nomeAtaque, ataque.getNomeAtaque());

    }

    @Test
    public void deve_ser_obrigatorio_informar_um_tipo() throws AcuraciaInvalidaException, ForcaInvalidaParaCategoriaException, TipoInvalidoParaCategoriaException {
        Tipo tipo = new Tipo("normal");

        Ataque ataque = new AtaqueBuilder().comTipo(tipo).construir();

        assertEquals(tipo, ataque.getTipo());
    }

    @Test
        public void nao_deve_ter_acuracia_menor_que_zero (){
            int acuracia = -1;

            assertThrows(AcuraciaInvalidaException.class, ()-> {

            Ataque ataque = new AtaqueBuilder().comAcuracia(acuracia).construir();
            });

            assertThrows(AcuraciaInvalidaException.class, ()-> {

            Ataque ataque = new AtaqueBuilder().comAcuracia(acuracia).comCategoriaEfeito().construir();
            });   
        }

    @Test
        public void nao_deve_ter_acuracia_maior_que_cem (){
            int acuracia = 101;

            assertThrows(AcuraciaInvalidaException.class, ()-> {

            Ataque ataque = new AtaqueBuilder().comAcuracia(acuracia).construir();
            });   

            assertThrows(AcuraciaInvalidaException.class, ()-> {

            Ataque ataque = new AtaqueBuilder().comAcuracia(acuracia).comCategoriaEfeito().construir();
            });   
        }

        @Test
        public void deve_poder__ter_acuracia_igual_a_zero() throws AcuraciaInvalidaException, ForcaInvalidaParaCategoriaException, TipoInvalidoParaCategoriaException{
            int acuraciaEsperada = 0;
            Ataque ataque = new AtaqueBuilder().comAcuracia(acuraciaEsperada).construir();
            
            assertEquals(acuraciaEsperada, ataque.getAcuracia());
        }

        @Test
        public void nao_deve_ter_forca_nem_tipo_quando_a_categoria_for_efeito () throws AcuraciaInvalidaException, ForcaInvalidaParaCategoriaException, TipoInvalidoParaCategoriaException{
            Categoria categoria = Categoria.EFEITO;
            int forca =0;
            Tipo tipo = null;
            
            Ataque ataque = new AtaqueBuilder().comCategoriaEfeito().construir();

            assertEquals(categoria, ataque.getCategoriaAtaque());
            assertEquals(forca, ataque.getForca());
            assertEquals(tipo, ataque.getTipo());
        }

        @Test
        public void nao_deve_ter_ataque_da_categoria_fisico_sem_forca () {
            Categoria categoria = Categoria.FISICO;
            int forca = 0;

            assertThrows(ForcaInvalidaParaCategoriaException.class, ()-> {
                new AtaqueBuilder().comForca(forca).comCategoria(categoria).construir(); 
            });

        }

        @Test
        public void nao_deve_ter_ataque_da_categoria_fisica_sem_tipo () {
            Categoria categoria = Categoria.FISICO;
            Tipo tipo = null;

            assertThrows(TipoInvalidoParaCategoriaException.class, ()-> {
                new AtaqueBuilder().comTipo(tipo).comCategoria(categoria).construir(); 
            });

        }
        
        @Test
        public void nao_deve_ter_ataque_da_categoria_especial_sem_forca () {
            Categoria categoria = Categoria.ESPECIAL;
            int forca = 0;

            assertThrows(ForcaInvalidaParaCategoriaException.class, ()-> {
                new AtaqueBuilder().comForca(forca).comCategoria(categoria).construir(); 
            });

        }

        @Test
        public void nao_deve_ter_ataque_da_categoria_especial_sem_tipo () {
            Categoria categoria = Categoria.ESPECIAL;
            Tipo tipo = null;

            assertThrows(TipoInvalidoParaCategoriaException.class, ()-> {
                new AtaqueBuilder().comTipo(tipo).comCategoria(categoria).construir(); 
            });

        }
}
