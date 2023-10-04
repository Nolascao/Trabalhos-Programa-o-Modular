/* 
 * AUTOR: Matheus Nolasco Miranda Soares
 * DATA: 11/05/2022
 * 
 * */

public class Livros {
    private String nome; 
    private int codigo;
    private Data dataEmprestimo; 
    private Data dataDevolucao; 
    private int qtdeEmprestimos=0;
    private Cliente clienteEmPosse;
    
    public String getNome() {
        return nome;
    }  
    public Cliente getClienteEmPosse() {
        return clienteEmPosse;
    }
    public void setClienteEmPosse(Cliente clienteEmPosse) {
        this.clienteEmPosse = clienteEmPosse;
    }
    public void setNome(String nome) {
        this.nome = nome;
    } 

    public int getQtdeEmprestimos() {
        return qtdeEmprestimos;
    }
    public void setQtdeEmprestimos() {
        this.qtdeEmprestimos += 1;
    }     

    public Data getDataEmprestimo() {
        return dataEmprestimo;
    }
    public void setDataEmprestimo(Data dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo; 
        this.dataDevolucao = dataEmprestimo.adicionarDias(7);
    }

    public Data getDataDevolucao() {
        return dataDevolucao;
    } 

    public void setDataDevolucao(Data dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
      
     /** 
      * Compara dois objetos do tipo livro baseado no nome deles
        @param o objeto que será comparado 
      */

    @Override 
    public boolean equals(Object o){ 
        Livros outro = (Livros) o;
        return this.nome.equals(outro.nome); 
    }

    /* 
       Imprimi um texto com os dados do empréstimo mais recente desse livro 
    */

    public void emprestimoMaisRecente(){ 
        System.out.println("O empréstimo mais recente desse livro foi feito pelo Cliente: "+ clienteEmPosse.getNome()+", no dia "+ this.getDataEmprestimo().toString()+ "e deve ser devolvido no dia "+this.getDataDevolucao().toString());
    }
    
}
