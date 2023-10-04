public class App {
    public static void main(String[] args) throws Exception {
        miniJogo jogador1 = new miniJogo();
        miniJogo jogador2 = new miniJogo(); 
        
        jogador1.start(); 
        jogador2.start(); 
        
        jogador1.init();

        do{ 
        jogador2.join();
        jogador1.ChuteJogador(50); 
        jogador2.ChuteJogador(40); 
        jogador2.join();

        if (jogador1.comparador() < jogador2.comparador(jogador2.getChute())){  
            jogador1.addPontuacao(); 
            jogador1.modificadorMaior(jogador1.getChute()); 
            System.out.println(jogador1.getValor());
        } 
        else{ 
            jogador2.addPontuacao();  
            jogador1.modificadorMenor(jogador2.getChute()); 
            System.out.println(jogador1.getValor());
        } 
        }while(jogador1.getPontuacao() == 5 || jogador2.getPontuacao() == 5);   
        //System.out.println(jogador1.getValor()); 
       // System.out.println(jogador2.getChute());  
      

    }
}
