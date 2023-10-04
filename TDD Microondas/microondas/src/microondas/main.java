package microondas;

public class main {
    public static void Main(String[] args){

        Microondas m = new Microondas();
       m.setTemporizador(4,30);  
        m.rodarTemporizador();
       System.out.println(m.getSegundos());  
     
    }
    
}
