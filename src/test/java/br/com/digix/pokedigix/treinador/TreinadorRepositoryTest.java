// package br.com.digix.pokedigix.treinador;

// import static org.junit.jupiter.api.Assertions.assertEquals;

// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

// @DataJpaTest
// public class TreinadorRepositoryTest { 
//     @Autowired
//     private TreinadorRepository treinadorRepository;


//     @Test
//     public void deve_salvar_um_treinador(){
//         String nome = "Sérgio";
//         double dinheiro = 100000 ;
//         double nivel = 80 ;
//         Long id = 1L;
//         Treinador treinador =  new Treinador(nome, dinheiro, nivel );

//         treinadorRepository.save(treinador);

//         assertEquals(id, treinador.getId());
//     }

// }
