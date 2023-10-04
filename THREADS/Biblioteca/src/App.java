import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* 
 * AUTOR: Matheus Nolasco Miranda Soares
 * DATA: 11/05/2022
 * 
 * 
 * Obs: Professor, essa é a matéria que eu tenho mais dificuldade na sua disciplina, desculpa pelos erros, foi o melhor que eu consegui fazer.
 * */





public class App extends Thread{

   

 

    

    public static void main(String[] args) throws Exception { 
        int TOTAL_LIVROS = 200_000;
        List<Livros> livros = new ArrayList<>();        //classe que encapsula a lista e os semáforos
       
        Biblioteca p1 = new Biblioteca(livros); //Produtor 
        livros = p1.carregarLivrosList();
        Random r = new Random(); 
        int aux = r.nextInt(p1.alunosCadastrados.size());                                     
        Cliente c1  =  p1.alunosCadastrados.get(aux);      //Consumidor 1 
        aux = r.nextInt(p1.alunosCadastrados.size());  
        Cliente c2  =   p1.alunosCadastrados.get(aux);     //Consumidor 2
        
        long iniTime = System.currentTimeMillis();      
        c1.start();
        p1.start();
        c2.start();

        p1.join();
        c1.join();
        c2.join();
        long finTime =  System.currentTimeMillis();                        
        
        System.out.println("Sync - Time elapsed: "+(finTime-iniTime));      //visualização do tempo de execução
        System.out.println("List Size: " livros.size());               //a lista deve estar vazia ao final
    }
}
