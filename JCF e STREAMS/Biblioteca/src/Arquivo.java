/* 
 * AUTOR: Matheus Nolasco Miranda Soares
 * DATA: 11/05/2022
 * 
 * */

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Arquivo {
    
    /**
     * Le um arquivo e retorna uma lista de strigns, cada indice da lista contém uma linha do arquivo
     * 
     * @param nomeDoArquivo = nome do arquivo que será lido
     * @return retorna a lista de dados
     * @throws IOException = caso de algo errado na entrada
     */


    public List<String> leituraDeArquivo(String nomeDoArquivo) throws IOException{
        Scanner leitor = new Scanner(new FileReader("Biblioteca/resources/"+nomeDoArquivo)); 
        List<String> dados = new ArrayList<>();
        while(leitor.hasNext()){ 
         dados.add(leitor.nextLine());  
        } 
        leitor.close(); 
        return dados; 
    }
}
