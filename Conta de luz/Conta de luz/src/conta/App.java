package conta;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!"); 
        Pessoa p =new Pessoa(); 
        p.RegistrarImovel(1, "Residencial"); 
        p.Imovel.registrarLeitura(12.2); 
        p.Imovel.registrarLeitura(14.2);  
        p.Imovel.registrarLeitura(15.2);
        System.out.println("" + p.Imovel.Conta.getLeituraMesAtual()  + p.Imovel.Conta.getLeituraMesAnterior()  ); 
    }
}
