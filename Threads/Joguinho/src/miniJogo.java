import java.util.Random;

public class miniJogo extends Thread {
    private int valor;
    private jogador Jogador = new jogador();

    public void init(){ 
        this.gerarValor(100);
    } 

    public void modificadorMenor(int modificador){ 
        this.gerarValor(modificador);
    } 

    public void modificadorMaior(int modificador){ 
        Random random = new Random(); 
        int aux = (this.Jogador.getChute() - 100); 
        if (aux<0){ 
            aux = aux * -1;
        }
        int numero = random.nextInt(aux) + modificador;  
        this.valor = numero;
    }

    private void gerarValor (int modificador){ 
         Random random = new Random(); 
         int numero = random.nextInt(modificador);
         this.valor = numero;
    }   

    public void ChuteJogador(int chute) { 
        this.Jogador.setChute(chute);
    }  

    public int getChute(){ 
        return this.Jogador.getChute();
    }
 
    public int getValor() {
        return this.valor;
    }

    public int comparador() { 
        if ((this.valor - this.Jogador.getChute()) < 0) 
        return (this.valor - this.Jogador.getChute()) * -1; 
        else { 
            return (this.valor - this.Jogador.getChute());
        }
    } 

    public int comparador(int valorJogador2) { 
        if ((this.valor - valorJogador2) < 0) 
        return (this.valor - valorJogador2) * -1; 
        else { 
            return (this.valor - valorJogador2);
        }
    }
    
    public void addPontuacao() {
        this.Jogador.addPontuacao();
    } 

    public int getPontuacao (){ 
        return this.Jogador.getPontuacao(); 
    }

}