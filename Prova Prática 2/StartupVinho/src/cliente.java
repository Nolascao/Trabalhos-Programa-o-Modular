import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class cliente {
    public String nome; 
    private String CPF; 
    private List <compra> pedidos; 
    private INivelCliente nivel; 

    public void Cliente(){ 
        this.nome = " "; 
        this.CPF = " "; 
        this.pedidos = new LinkedList<>(); 
    } 

    public void Cliente(String name, String cpf){ 
        this.nome = name; 
        this.CPF = cpf; 
        this.pedidos = new LinkedList<>(); 
    } 

    public String getNome() {
        return this.nome;
    } 

    public String getCPF() {
        return this.CPF;
    } 

    public Collection<compra> getPedidos() {
        return this.pedidos;
    } 

    public void setCPF(String cPF) {
        this.CPF = cPF;
    } 

    public void setNome(String nome) {
        this.nome = nome;
    } 

    public void addPedidos(compra Compra) {
        this.pedidos.add(Compra);
    } 

    public double consultaValorVinho(vinho Qual){ 
        return Qual.getPreco();
    } 
    
    public String extratoCompras(){ 
       String extrato = new String();
       extrato = "Mensalidade: " + nivel.getMensalidade() * 12 + " ";  
       for(int i=0; i<= pedidos.size(); i++){  
        extrato += "Compras: " +  pedidos.get(i).calcValorTotal()+ " ";
       }
       
       return  extrato;

    } 

}

