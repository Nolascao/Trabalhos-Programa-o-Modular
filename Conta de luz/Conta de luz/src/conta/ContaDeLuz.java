package conta;


/** 
 *  AUTOR: Matheus Nolasco Miranda Soares 
 *  DATA: 17/09/2021
 * 
 */

public class ContaDeLuz { 
    private double leituraMesAnterior; 
    private double leituraMesAtual = 0;  
    private int mesAtual = 0;  
    private Imovel i;  
    private Pessoa p; 
    private double maiorConsumo = 0;  
    private int maiorConsumoMes;

    /**
     *  ContaDeLuz(double,Imovel,Pessoa) 
     * 
     *  Método construtor da classe chamado na primeira vez que ela é iniciada;
     * 
     * @param leituraMesAtual = A leitura daquele mês
     * @param i = O imóvel do qual a conta pertence 
     * @param p = A pessoa da qual o Imóvel pertence
     */

    public ContaDeLuz(double leituraMesAtual, Imovel i, Pessoa p) { 
        this.i = i; 
        this.p=p;
        this.leituraMesAnterior = this.leituraMesAtual;
        this.leituraMesAtual = leituraMesAtual;     
        this.mesAtual++;
    }

    /**
     * Método Get da variável leituraMesAtual
     * 
     * @return
     */

    public double getLeituraMesAtual() {
        return leituraMesAtual;
    } 

    /**
     *  Método get da variável leituraMesAnterior
     * 
     * @return
     */

    public double getLeituraMesAnterior() {
        return leituraMesAnterior;
    }  
    
    /**
     *  Método get da variável maiorConsumoMes
     * 
     * @return
     */
    
    public int getMaiorConsumoMes() {
        return maiorConsumoMes;
    } 

    /**
     *  Método get da variável mesAtual
     *  
     * @return
     */

    public int getMesAtual() {
        return mesAtual;
    } 

    /**
     *  setLeituraMesAtual(double) : void
     * 
     *  Método que determina as próximas leituras após a primeira, além disso ele determina o valor da variável leituraMesAnterior e atualiza o valor das variáveis mesAtual,
     *  maiorConsumo e maiorConsumoMes , caso o variável mesAtual passe do valor 12, ou seja, passe de um ano, este método reseta o valor das variáveis mesAtual, leituraMesAtual e 
     *  maiorConsumo. 
     * 
     * @param leituraMesAtual = Leitura do mês atual
     */

    public void setLeituraMesAtual(double leituraMesAtual) { 
        this.leituraMesAnterior = this.leituraMesAtual;
        this.leituraMesAtual = leituraMesAtual;  
        if (this.mesAtual < 13){ 
            this.mesAtual++;
        }
        else{ 
            this.mesAtual = 1;  
            this.leituraMesAtual = this.leituraMesAtual - this.leituraMesAnterior; //Toda virada de ano fiscal os valores do ano passado são resetados
            this.maiorConsumo = 0;
        } 
        if(this.leituraMesAtual > this.maiorConsumo ){ 
            this.maiorConsumo = this.leituraMesAtual; 
            this.maiorConsumoMes = this.mesAtual;
      } 
    }
    
    /**
     *  consumo() : double 
     * 
     *  Retorna o valor do consumo total daquele mês, já aplicando a Tarifa Básica, visto que, ela é aplicada na soma de valores independente da condição. Utiliza a função 
     *  tarifaBasica() para receber o valor da Tarifa Básica.
     * 
     * @return
     */

    private double consumo(){ 
         return (this.leituraMesAtual - this.leituraMesAnterior) * this.tarifaBasica();
    }

    /**
     *  tarifaBasica() : double 
     * 
     *  Retorna o valor que será multiplicado pelo consumo mensal.
     * 
     * @return
     */

    private double tarifaBasica(){ 
        if(p.getTipoRenda() == "Alta") { 
            return 0.6443;
        } 
        else{ 
            return 0.5253; 
        }
    }  

    /**
     *  taxaExtra() : double 
     * 
     *  Retorna o valor da taxa extra aplicada a cada 100kWh consumidos naquele mês.
     * 
     * @return
     */

    private double taxaExtra(){ 
        return ((this.leituraMesAtual - this.leituraMesAnterior)/100) * 14.2;
    } 

    /**
     *  valorImpostos() : double  
     * 
     *  Retorna o valor em impostos que está sendo cobrado na conta.
     * 
     * @return
     */

    public double valorImpostos(){ 
        if (this.i.getTipo() == "Residencial") 
            return this.consumo()* 0.4285; 
        else{ 
            return this.consumo() * 0.333;
        } 
    }

    /**
     *  valorTotal() : double 
     * 
     *  Retorna o valor total da conta de luz naquele mês, aplicando a condição de insenção de impostos e da taxa extra;
     * 
     * 
     * @return
     */

    public double valorTotal(){ 
        if ( this.i.getTipo() == "Residencial" && this.p.getTipoRenda() == "Baixa" && (this.leituraMesAtual - this.leituraMesAnterior)<=90)
            return this.consumo();
        else{ 
            return this.consumo() + this.valorImpostos() + this.taxaExtra();
        }
    } 

    /**
     *  valorSemImpostos() : double 
     * 
     *  Retorna o valor da Conta de luz caso ela não tivesse impostos.
     * 
     * @return
     */

    public double valorSemImpostos(){ 
        return this.valorTotal() - this.valorImpostos();
    }

}