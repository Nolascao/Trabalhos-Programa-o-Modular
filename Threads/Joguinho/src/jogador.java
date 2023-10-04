public class jogador {
    private int pontuacao = 0; 
    private int chute; 

    public void setChute(int chute) {
        this.chute = chute;
    }
    
    public int getChute() {
        return this.chute;
    } 

    public void addPontuacao() {
        this.pontuacao ++;
    } 

    public int getPontuacao() {
        return this.pontuacao;
    }
}