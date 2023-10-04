/* 
 * AUTOR: Matheus Nolasco Miranda Soares
 * DATA: 11/05/2022
 * 
 * */

import java.util.List;
import java.util.Random;


public class Cliente extends Thread {
   private String nome;
   private int matricula; 
   private int qtdeEmprestimos; 
   List<Livros> livros;  
   List<Livros> possiveisLivros; 
   
   public Cliente(){ 
      this.nome=" "; 
      this.matricula=0;
   }
   
   public Cliente(String nome, int matricula, int qtdeEmprestimos){ 
      this.nome = nome; 
      this.matricula = matricula; 
      this.qtdeEmprestimos = qtdeEmprestimos; 
   } 

   public void setPossiveisLivros(List<Livros>l){ 
      this.possiveisLivros = l;
   }
   
   public String getNome() {
      return nome;
   } 
   public void setNome(String nome) {
      this.nome = nome;
   }

   public int getQtdeEmprestimos() {
      return qtdeEmprestimos + livros.size();
   }
   public void setQtdeEmprestimos(int qtdeEmprestimos) {
      this.qtdeEmprestimos = qtdeEmprestimos;
   }

   public long getMatricula() {
      return matricula;
   }
   public void setMatricula(int matricula) {
      this.matricula = matricula;
   } 

   /** 
    Atribui um livro a um cliente
    @param livro = livro que será atribuido
    @param dia,mes,ano = dia, mes e ano que o livro foi pego emprestado
   
   */
 
   public void pegarLivroEmprestado(Livros livro, int dia, int mes, int ano){ 
       if (livro.estaEmprestado() == false){ 
         Data dataEmprestimo = new Data(dia, mes, ano); 
         livro.setDataEmprestimo(dataEmprestimo);
         this.livros.add(livro);  
         livro.setQtdeEmprestimos(); 
         livro.setClienteEmPosse(this);
         this.qtdeEmprestimos++; 
       }
   } 

   @Override 
   public void run(){  
      Random r = new Random(); 
      int contErros = 0; 
      int sum =0;
      for (int i=0;i<this.possiveisLivros.size();i++){ 
            try { 

               if (this.possiveisLivros.get(i).estaEmprestado() == false){ 
                  this.possiveisLivros.remove(i); 
                  sum += this.possiveisLivros.get(i).getCodigo();
                }   //remove da lista; método encapsula o uso de semáforo.
            } catch (InterruptedException e) {
                contErros++;
            }      
            
        }

        try {
            System.out.println("Consumer out (id "+this.matricula+ "): | Lista: "+this.possiveisLivros.size()+" | Total: "+sum+ "| Errors: "+contErros);
        } catch (InterruptedException e) {
             e.printStackTrace();
        }
      
      
   }

/**
 * Renova o emprestimo de um livro, adicionando mais 7 dias a sua data de devolucao
 * @param livro = livro que terá o empréstimo renovado
 */

   public void renovarEmprestimo(Livros livro){ 
      for(int i=0;i<this.livros.size();i++){ 
         if(livro.equals(this.livros.get(i))){  
            livro.getDataDevolucao().adicionarDias(7);
         }
      }
   }
   @Override 
   public String toString(){  
      return "Nome:" + this.nome + "/ Matrícula: " + Integer.toString(this.matricula);
   }
   
}



