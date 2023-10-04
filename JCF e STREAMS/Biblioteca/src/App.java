
/* 
 * AUTOR: Matheus Nolasco Miranda Soares
 * DATA: 11/05/2022
 * 
 * */



import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class App {

    /**
     *  Carrega os livros do documento livros.txt
     * @return retorna esses livros em um HashMap
     * @throws IOException caso algo de errado na leitura do arquivo
     */

    public static HashMap<Integer,Livros> carregarLivrosHash() throws IOException{ 
        Arquivo arquivo = new Arquivo(); 
        List<String> dados = new ArrayList<>(); 
        HashMap<Integer,Livros> livros = new HashMap<>(); 
        dados = arquivo.leituraDeArquivo("livros.txt");
        for(int i=0; i<dados.size();i++){ 
            String[] dados_formatados = dados.get(i).split(";");  
            int codigo = Integer.parseInt(dados_formatados[0]);
            Livros livro = new Livros(); 
            livro.setCodigo(codigo); 
            livro.setNome(dados_formatados[1]); 
            livros.put(codigo,livro);
        } 
        return livros;
    } 

    /**
     *  Carrega os livros do documento livros.txt
     * @return retorna esses livros em um List
     * @throws IOException caso algo de errado na leitura do arquivo
     */

    public static List<Livros> carregarLivrosList() throws IOException{ 
        Arquivo arquivo = new Arquivo(); 
        List<String> dados = new ArrayList<>(); 
        List<Livros> livros = new ArrayList<>(); 
        dados = arquivo.leituraDeArquivo("livros.txt");
        for(int i=0; i<dados.size();i++){ 
            String[] dados_formatados = dados.get(i).split(";");  
            int codigo = Integer.parseInt(dados_formatados[0]);
            Livros livro = new Livros(); 
            livro.setCodigo(codigo); 
            livro.setNome(dados_formatados[1]); 
            livros.set(i, livro);
        } 
        return livros;
    }

    /**
     *  Carrega os clientes do documento clientes.txt
     * @return retorna esses livros em um HashMap
     * @throws IOException caso algo de errado na leitura do arquivo
     */

    public static HashMap<Integer,Cliente> carregarClientesHash() throws IOException{ 
        Arquivo arquivo = new Arquivo(); 
        List<String> dados = new ArrayList<>(); 
        HashMap<Integer,Cliente> clientes = new HashMap<>(); 
        dados = arquivo.leituraDeArquivo("clientes.txt");
        for(int i=0; i<dados.size();i++){ 
            String[] dados_formatados = dados.get(i).split(";");  
            int matricula = Integer.parseInt(dados_formatados[0]); 
            int qtdeEmprestimos = Integer.parseInt(dados_formatados[2]); 
            Cliente cliente = new Cliente(); 
            cliente.setMatricula(matricula);
            cliente.setNome(dados_formatados[1]); 
            cliente.setQtdeEmprestimos(qtdeEmprestimos); 
            clientes.put(matricula,cliente);
        } 
        return clientes;
    }  

    /**
     *  Carrega os clientes do documento clientes.txt
     * @return retorna esses livros em um List
     * @throws IOException caso algo de errado na leitura do arquivo
     */

    public static List<Cliente> carregarClientesList() throws IOException{ 
        Arquivo arquivo = new Arquivo(); 
        List<String> dados = new ArrayList<>(); 
        List<Cliente> clientes = new ArrayList<>(); 
        dados = arquivo.leituraDeArquivo("clientes.txt");
        for(int i=0; i<dados.size();i++){ 
            String[] dados_formatados = dados.get(i).split(";");  
            int matricula = Integer.parseInt(dados_formatados[0]); 
            int qtdeEmprestimos = Integer.parseInt(dados_formatados[2]); 
            Cliente cliente = new Cliente(); 
            cliente.setMatricula(matricula);
            cliente.setNome(dados_formatados[1]); 
            cliente.setQtdeEmprestimos(qtdeEmprestimos); 
            clientes.set(i, cliente);
        } 
        return clientes;
    }  

    /**
     * Busca qual o livro com a maior quantidade de empréstimos
     * @param livros = Lista de livros existentes
     * @return = retorna o livro que corresponde a condição
     */

    public Livros livroMaisEmprestado(List<Livros> livros){ 
        Livros maiorEmprestimo = new Livros();
        
        for(int i=0; i<livros.size();i++){ 
            if (livros.get(i).getQtdeEmprestimos()> maiorEmprestimo.getQtdeEmprestimos())
                maiorEmprestimo = livros.get(i);
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
        
        for(int i=0; i<clientes.size();i++){ 
            if (clientes.get(i).getQtdeEmprestimos()> maiorEmprestimo.getQtdeEmprestimos())
                maiorEmprestimo = clientes.get(i);
        } 
        return maiorEmprestimo;
    }

    public static void main(String[] args) throws Exception {
     List<Cliente>c = carregarClientesList(); 
        for(int i=0;i<c.size();i++){ 
            System.out.println(c.get(i));
        }
    }
}
