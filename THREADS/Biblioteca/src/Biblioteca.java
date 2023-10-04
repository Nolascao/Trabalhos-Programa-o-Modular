import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca extends Thread {
    
    List<Cliente> alunosCadastrados;
    List<Livros> livros;  
    List<Livros> preLivros;
    
    /**
     *  Carrega os livros do documento livros.txt
     * @return retorna esses livros em um List
     * @throws IOException caso algo de errado na leitura do arquivo
     */ 

     
     public Biblioteca(List<Livros> l) throws IOException{ 
        this.carregarLivrosList();  
        this.carregarClientesList();  
        preLivros = l;
     }

    public List<Livros> carregarLivrosList() throws IOException{ 
        Arquivo arquivo = new Arquivo(); 
        List<String> dados = new ArrayList<>(); 
        List<Livros> livros = new ArrayList<>(); 
        dados = arquivo.leituraDeArquivo("livros.txt");
        for(int i=0; i<dados.size();i++){ 
            String[] dados_formatados = dados.get(i).split(";");  
            Livros livro = new Livros(dados_formatados[1],Integer.parseInt(dados_formatados[0])); 
            livros.add(livro);
        } 
        //this.livros =  livros; 
        //this.preLivros = livros; 
        return livros;
    }
 
 /**
     *  Carrega os clientes do documento clientes.txt
     * @return retorna esses livros em um List
     * @throws IOException caso algo de errado na leitura do arquivo
     */

    private void carregarClientesList() throws IOException{ 
        Arquivo arquivo = new Arquivo(); 
        List<String> dados = new ArrayList<>(); 
        List<Cliente> clientes = new ArrayList<>(); 
        dados = arquivo.leituraDeArquivo("clientes.txt");
        for(int i=0; i<dados.size();i++){ 
            String[] dados_formatados = dados.get(i).split(";");  
            Cliente cliente = new Cliente(dados_formatados[1],Integer.parseInt(dados_formatados[0]),Integer.parseInt(dados_formatados[2])); 
            clientes.add(cliente);
        } 
        this.alunosCadastrados =  clientes;
    }   

    /**
     * Busca qual o livro com a maior quantidade de empréstimos
     * @param livros = Lista de livros existentes
     * @return = retorna o livro que corresponde a condição
     */

    public Livros livroMaisEmprestado(){ 
        Livros maiorEmprestimo = new Livros();
        
        for(int i=0; i<this.livros.size();i++){ 
            if (this.livros.get(i).getQtdeEmprestimos()> maiorEmprestimo.getQtdeEmprestimos())
                maiorEmprestimo = this.livros.get(i);
        } 
        return maiorEmprestimo;
    } 

    /**
     * Busca qual o cliente com a maior quantidade de empréstimos
     * @param clientes = Lista de clientes existentes
     * @return = retorna o cliente que corresponde a condição
     */

    public Cliente clienteMaisFrequente(List<Cliente> clientes){ 
        Cliente maiorEmprestimo = new Cliente();
        
        for(int i=0; i<this.alunosCadastrados.size();i++){ 
            if (this.alunosCadastrados.get(i).getQtdeEmprestimos()> maiorEmprestimo.getQtdeEmprestimos())
                maiorEmprestimo = this.alunosCadastrados.get(i);
        } 
        return maiorEmprestimo;
    } 

    public void cadastrarAlunos(Cliente aluno){ 
        this.alunosCadastrados.add(aluno);
    } 

    public void cadastrarLivro(Livros livro){ 
        this.livros.add(livro);
    } 

    @Override
    public String toString(){
        return this.alunosCadastrados.toString() + " " + this.livros.toString();
    } 

    @Override 
    public void run() {  
        int contErros =0; 
        int sum=0;
        for(int i=0;i<this.preLivros.size();i++){ 
            try{
                this.livros.add(this.preLivros.get(i));
                sum += this.livros.get(i).getCodigo(); 
            }catch(InterruptedException e){
                contErros++;
            }    
            
        }

        try {
            System.out.println("Lista: "+this.livros.size()+" | Total: "+sum+ "| Errors: "+contErros);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        }
        
    }
