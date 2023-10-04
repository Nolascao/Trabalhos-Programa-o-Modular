package microondas;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;


/** 
      Um micro-ondas apresenta as características: 
      -Pode ser programado com um temporizador, indicando por quantos minutos e segundos ele deve funcionar. 
      -Pode ser pausado, reiniciado e desligado a qualquer momento pelo usuário. 
      -Só pode ser ligado se a porta estiver fechada, e sua porta só pode ser aberta quando ele estiver desligado.
      -Deve atualizar corretamente o temporizador quando estiver em funcionamento e sinalizarem a passagem de tempo
      */

/**
 *  1-Testar o funcionamento do temporizador 
 *  2-Testar as interações com porta aberta e fechada 
 *  3-Testar o Ligar 
 *  4-Testar o Pause
 *  5-Testar o Reiniciar
 *  6-Testar o Desligar
 *  
 *  
 */



 public class MicroondasTest {

    static Microondas m; 

    @BeforeEach
    public void init (){ 
        m = new Microondas();
    } 

    @Test
    public void testarTemporizadorSegundos (){ 
        this.init();      
        m.setTemporizador(0,30);
       assertEquals(30, m.getSegundos());
    } 

    @Test
    public void testarTemporizadorMinutos (){ 
        this.init();      
        m.setTemporizador(5,0);
       assertEquals(5, m.getMinutos());
    }  
    
    @Test
    public void testarAbrirPorta (){ 
        this.init();      
        m.abrirPorta();
       assertEquals("Aberta", m.statusPorta());
    }  

    @Test
    public void testarFecharPorta (){ 
        this.init();      
        m.fecharPorta();
       assertEquals("Fechada", m.statusPorta());
    } 

    @Test
    public void testarLigarPortaAberta (){ 
        this.init();  
        m.init();      
        m.fecharPorta(); 
        m.Ligar();
       assertEquals("Ligado", m.getStatusMicroondas());
    }  

    @Test
    public void testarLigarPortaFechada (){ 
        this.init(); 
        m.init();      
        m.abrirPorta(); 
        m.Ligar();
       assertEquals("Desligado", m.getStatusMicroondas());
    }  

    @Test
    public void testarPausarPassagemTempo (){ 
        this.init(); 
        m.setTemporizador(2, 30);    
        assertEquals(2, m.getMinutos());  
        m.fecharPorta(); 
        m.Ligar();  
        m.Pausar(1, 30);
        m.rodarTemporizador();
       assertEquals(1, m.getMinutos()); 
       assertEquals(30, m.getSegundos());
    }  

    @Test
    public void testarDespausarPassagemTempo (){ 
        this.init(); 
        m.setTemporizador(2, 30);   
        m.fecharPorta(); 
        m.Ligar();  
        m.Pausar(1, 30);
        m.rodarTemporizador();
        assertEquals(1, m.getMinutos()); 
        assertEquals(30, m.getSegundos()); 
        m.Despausar();
        m.rodarTemporizador();  
        assertEquals(0, m.getMinutos()); 
        assertEquals(0, m.getSegundos()); 

    }  

    @Test
    public void testarReiniciarPassagemTempo (){ 
        this.init(); 
        m.setTemporizador(2, 30);     
        m.fecharPorta(); 
        m.Ligar();  
        m.Pausar(1, 30);
        m.rodarTemporizador(); 
        m.Despausar();
        m.Reiniciar(); 
        assertEquals(2, m.getMinutos()); 
        assertEquals(30, m.getSegundos()); 
        m.rodarTemporizador(); 
    }  

    @Test
    public void testarDesligarPassagemTempo (){ 
        this.init(); 
        m.setTemporizador(2, 30);     
        m.fecharPorta(); 
        m.Ligar(); 
        m.Desligar(); 
        assertEquals("Desligado", m.getStatusMicroondas()); 
        assertEquals(0, m.getMinutos()); 
        assertEquals(0, m.getSegundos()); 
        m.rodarTemporizador(); 
        assertEquals("Desligado", m.getStatusMicroondas()); 
        assertEquals(0, m.getMinutos()); 
        assertEquals(0, m.getSegundos()); 
        

    } 


}
