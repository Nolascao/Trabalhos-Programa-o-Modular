/* 
 * AUTOR: Matheus Nolasco Miranda Soares
 * DATA: 11/05/2022
 * 
 * */

import java.util.List;

public class Cliente {
   private String nome;
   private int matricula; 
   private int qtdeEmprestimos; 
   List<Livros> livros; 
   
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
         Data dataEmprestimo = new Data(dia, mes, ano); 
         livro.setDataEmprestimo(dataEmprestimo);
         livros.set(livros.size()-1,livro);  
         livro.setQtdeEmprestimos(); 
         livro.setClienteEmPosse(this);
         qtdeEmprestimos++;
   } 

/**
 * Renova o emprestimo de um livro, adicionando mais 7 dias a sua data de devolucao
 * @param livro = livro que terá o empréstimo renovado
 */

   public void renovarEmprestimo(Livros livro){ 
      for(int i=0;i<livros.size();i++){ 
         if(livro.equals(livros.get(i))){  
            livro.getDataDevolucao().adicionarDias(7);
         }
      }
   }

   
}



