package conta;



public class Imovel {
    private String tipo = new String(); 
    private int numRegistro; 
    public ContaDeLuz Conta;  
    private Pessoa p;

    public Imovel(int numRegistro, String tipo, Pessoa p){ 
        if (tipo == "Residencial" || tipo == "Comercial") 
            this.tipo = tipo; 
        else{ 
            this.tipo = "Residencial";
        } 
        this.numRegistro = numRegistro; 
        this.p = p;
    }

    /**
     *  registrarLeitura(double) : void 
     * 
     *  Se não tiver sido criado uma conta para esse imóvel, chama a função construtora inicial, se já tiver, chama a função para adicionar leitura de um novo mês
     * 
     * @param leituraMesAtual
     */

    public void registrarLeitura(double leituraMesAtual){ 
        if (Conta == null)
        Conta = new ContaDeLuz(leituraMesAtual,this,p); 
        else { 
            Conta.setLeituraMesAtual(leituraMesAtual);
        }
    }

    public int getNumRegistro() {
        return numRegistro;
    } 

    public void setNumRegistro(int numRegistro) {
        this.numRegistro = numRegistro;
    } 

    public String getTipo() {
        return tipo;
    } 

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }  

    /**
     *  mediaAnual() : double 
     * 
     *  Retorna a Média anual de consumo desse imóvel, para isso utiliza as funções getLeituraMesAtual() e getMesAtual(). Importante observar que, o valor da função getLeituraMesAtual(),  
     * é o valor somado de todas as leituras feitas até aquele momento no ano, por isso não há a necessidade de criar uma nova variável para isso. 
     * 
     * @return
     */

    public double mediaAnual(){ 
        if(this.Conta.getMesAtual() < 12)
            return this.Conta.getLeituraMesAtual()/this.Conta.getMesAtual(); 
        else{ 
            return this.Conta.getLeituraMesAtual()/12; 
        } 
    }  

    /**
     *  int maiorConsumoMes() : int 
     * 
     *  retorna o Mês que teve o maior consumo até o momento, daquele ano
     * 
     * @return
     */

    public int maiorConsumoMes(){ 
        return this.Conta.getMaiorConsumoMes();
    }

}
