package conta;

public class Pessoa {
    private long cpf; 
    private String tipoRenda = new String();   
    public Imovel Imovel;

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }  

    public long getCpf() {
        return cpf;
    } 

    public void setTipoRenda(String tipoRenda) {
        if (tipoRenda == "Baixa" || tipoRenda == "Alta") 
            this.tipoRenda = tipoRenda; 
        else{ 
            this.tipoRenda = "Alta";
        }
    } 

    public String getTipoRenda() {
        return tipoRenda;
    }  
    
    /**
     *  RegistrarImovel(int, String) : void 
     * 
     *  Registra um novo imóvel naquela pessoa, ou seja, cria um novo objeto imovel.
     * 
     * @param numRegistro = Número de registro do Imóvel 
     * @param tipo = Tipo do Imóvel
     */

    public void RegistrarImovel(int numRegistro, String tipo) {
        Imovel = new Imovel(numRegistro, tipo,this);
    }
 
    /**
     *  validarCadastro(long) : boolean 
     * 
     *  Confere se o cpf passado por parâmetro já foi registrado
     * 
     * 
     * @param cpf = cpf da pessoa
     * @return
     */

    public boolean validarCadastro(long cpf){ 
        if (this.cpf == cpf) 
            return true; 
        else{ 
            return false;
        }
    } 
 
    /**
     *  totalDevido() : double 
     * 
     *  Retorna o total devido por aquela pessoa naquele mês.
     * 
     * @return
     */

    public double totalDevido(){ 
        return this.Imovel.Conta.valorTotal();
    }
}
