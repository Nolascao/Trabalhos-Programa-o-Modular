package microondas;

/** 
      Um micro-ondas apresenta as características: 
      -Pode ser programado com um temporizador, indicando por quantos minutos e segundos ele deve funcionar. 
      -Pode ser pausado, reiniciado e desligado a qualquer momento pelo usuário. 
      -Só pode ser ligado se a porta estiver fechada, e sua porta só pode ser aberta quando ele estiver desligado.
      -Deve atualizar corretamente o temporizador quando estiver em funcionamento e sinalizarem a passagem de tempo
      */

/**
 *  AUTOR: Matheus Nolasco Miranda Soares
 *  DATA: 04/09/2021
 */

public class Microondas {
    private int minutosOriginais; 
    private int minutos; 
    private int segundos;  
    private int segundosOriginais; 
    private boolean porta; //True = Fechado , False = Aberto  
    private int statusMicroondas; //1 = Ligado, 2 = Desligado, 3 = Pausado, 
    private int tempoFinal; //normalmente seria 0, mas caso o usuário queira pausar o valor será maior
    private int tempoDesligar;

    public int getMinutos(){ 
        return this.minutos;
    } 

    public int getSegundos(){ 
        return this.segundos;
    }   

    public void init(){ 
      this.minutos = 0;
      this.segundos = 0;  
      this.minutosOriginais = 0;
      this.segundosOriginais = 0; 
      this.initPorta(); //A porta de um microondas sempre começa fechada 
      this.initStatusMicroondas(); //Microondas sempre começa desligado
      this.tempoFinal = 0; 
      this.tempoDesligar = 0;
    }
    
    /**
     *  setTemporizador(int,int) : void 
     * 
     *  Serve para setar o tempo desejado para o timer do microondas, além de setar algumas variáveis importantes
     * @param Minutos = Minutos desejados
     * @param Segundos = Segundos Desejados
     */

    public void setTemporizador(int Minutos, int Segundos){ 
        this.minutos = Minutos;  
        this.minutosOriginais = Minutos;
        this.segundos = Segundos; 
        this.segundosOriginais = Segundos;   
        this.tempoFinal = 0; 
        this.tempoDesligar = 0;
    } 
    
    public void initPorta(){ 
        this.porta = true;
    }  

    public void initStatusMicroondas(){ 
        this.statusMicroondas = 2;
    }
    
    /** 
     *  abrirPorta() : void 
     * 
     *  Serve para abrir a porta, caso o microondas esteja desligado
     */

    public void abrirPorta(){ 
       if(this.statusMicroondas == 2) //Se tiver desligado, pode abrir a porta
        this.porta = false;
    } 

    /** 
     *  fecharPorta() : void 
     * 
     *  Serve para fechar a porta do microondas;
     */

    public void fecharPorta(){ 
        this.porta = true;
    } 

     /** 
     *  statusPorta() : String
     * 
     *  Retorna o status da porta, se está aberta ou fechada
     */

    public String statusPorta(){ 
        if (this.porta == true){ 
            return "Fechada";
        } 
        else{ 
            return "Aberta";
        }
    } 
    
     /** 
     *  Ligar() : void
     * 
     *  Server para ligar o microondas caso a porta esteja fechada
     */

    public void Ligar(){ 
        if(this.porta == true) 
            this.statusMicroondas = 1; //Ligado  
    } 

     /** 
     *  getStatusMicroondas() : String
     * 
     *  Retorna o status do microondas, se está ligado, desligado ou pausado
     */

    public String getStatusMicroondas(){
        String status = new String();
        switch(this.statusMicroondas){
            case 1: 
                status = "Ligado";
                break;
            case 2:
                status =  "Desligado";
                break; 
            case 3:
                status =  "Pausado";
                break;
        } 
        return status;
    } 
    
     /** 
     *  rodarTemporizador() : void
     * 
     *  Roda o temporizador do microondas e, caso tenha sido estabelecido uma pausa ou desligamento
     *  em um momento específico ele para nesse momento e efetua o comando
     */

    public void rodarTemporizador(){ 
       if (getStatusMicroondas() == "Ligado"){ 
           int tempoTotal = (this.minutos * 60 ) + this.segundos;  
           while(tempoTotal >= this.tempoFinal && tempoTotal >this.tempoDesligar){ 
            if(tempoTotal > this.tempoDesligar){ 
               if (tempoTotal == this.tempoFinal){ 
                this.statusMicroondas = 3; 
                this.minutos = tempoTotal/60; 
                this.segundos = tempoTotal%60;  
                tempoTotal--;
                }
               else{  
                if ((tempoTotal%60)>=10)
                System.out.println((tempoTotal/60) + ":" + (tempoTotal%60));  
                else{ 
                System.out.println((tempoTotal/60) + ":0" + (tempoTotal%60));    
                } 
                tempoTotal--; 
               } 
               if(tempoTotal == this.tempoDesligar){ 
                   this.setTemporizador(0, 0);
                   this.statusMicroondas = 2;
               } 
            } 
            else{  
                if(tempoTotal == this.tempoDesligar){
                this.minutos = 0;
                this.segundos = 0;
                this.statusMicroondas = 2; 
                tempoTotal--;  
            }
            }
           } 
       }
    }  

     /** 
     *  Pausar(int,int) : void
     * 
     *  Se o microondas tiver ligado pausa o microondas nesse timer específico
     */

    public void Pausar(int minutoPausa, int SegundoPausa){ 
        if (getStatusMicroondas() == "Ligado"){ 
            this.tempoFinal = (minutoPausa * 60) + SegundoPausa;
        }
    } 
    
     /** 
     *  Despausar() : void
     * 
     *  Se o microondas tiver pausado despausa ele
     */

    public void Despausar(){ 
        if (getStatusMicroondas() == "Pausado"){  
            this.Ligar(); 
            this.tempoFinal = 0;
        }
    } 
    
     /**  
     *  Reiniciar() : void
     * 
     *  Se o microondas tiver ligado reinicia o timer com o valor colocado inicialmente
     */

    public void Reiniciar(){ 
        if (getStatusMicroondas() == "Ligado"){ 
            this.tempoFinal = 0;  
            this.minutos = this.minutosOriginais; 
            this.segundos = this.segundosOriginais;  
        } 
    } 
    
    /**  
     *  Desligar() : void
     * 
     *  Desliga o microondas na hora
     */

    public void Desligar(){ 
        this.minutos = 0;
        this.segundos = 0;
        this.tempoFinal = 0; 
        this.statusMicroondas = 2; 
    }
    
    /**  
     *  Desligar(int,int) : void
     * 
     *  Desliga o microondas em uma hora específica
     */

    public void Desligar(int minutos, int segundos){  
        this.tempoDesligar = (minutos * 60) + segundos; 
    }
    

}
