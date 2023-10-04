import java.util.LinkedList; 
import java.util.List;
import java.util.Random;

public class compra {
    private int id; 
    private List<vinho> itens; 
    private double valorPago; 
    
    public void Compra(){ 
        this.id = -1; 
        this.itens = new LinkedList<>(); 
        this.valorPago = 0;
    } 

    public void Compra(int valorPago){  
        Random random = new Random();
        this.id = random.nextInt(1000); 
        this.itens = new LinkedList<>(); 
        this.valorPago = 0;
    } 

    public int getId() {
        return this.id;
    }

    public List<vinho> getItens() {
        return this.itens;
    }
    public double getValorPago() {
        return this.valorPago;
    } 

    public void setId() {
        Random random = new Random();
        this.id = random.nextInt(1000);
    } 

    public void adicionarItens(vinho Vinho) {
        itens.add(Vinho);
    } 

    public double calcValorCompra(){  
       double Preco = 0;
       for(int i=0; i<= itens.size();i++){ 
           Preco += itens.get(i).getPreco();
       } 
       return Preco;
    } 

    public double calcValorFrete(){ 
        if (calcValorCompra() > 0 && calcValorCompra() <= 150) 
        return 15; 
        else{ 
            if (calcValorCompra() > 150 && calcValorCompra() <= 300) 
            return 10; 
            else{ 
                return 0;
            }
        }
    } 
    
    public double calcValorTotal(){ 
        this.valorPago = calcValorCompra() + calcValorFrete(); 
        return this.valorPago;
    }




}
