public class vinho { 
    private double preco; 
    public String nome; 
    private String pais; 
    private int ano; 
    private categoriaVinho categoria; 

    public void Vinho(){ 
       this.preco=0;
       this.nome=" "; 
       this.pais=" "; 
       this.ano=0; 
       this.categoria= categoriaVinho.SIMPLES;
    } 

    public void Vinho(double preco, String nome, String pais, int ano, String categoria){ 
        this.preco=preco;
        this.nome=nome; 
        this.pais=pais; 
        this.ano=ano;  
        switch(categoria.toLowerCase()){ 
            case "simples": this.categoria= categoriaVinho.SIMPLES; 
            case "elaborados": this.categoria = categoriaVinho.ELABORADO; 
            case "premium": this.categoria = categoriaVinho.PREMIUM;
        }
     } 
     
     public double getPreco() {
         return this.preco;
     }

     public int getAno() {
         return this.ano;
     }

     public String getNome() {
         return this.nome;
     }

     public String getPais() {
         return this.pais;
     }

     public void setAno(int ano) {
         this.ano = ano;
     }

     public void setNome(String nome) {
         this.nome = nome;
     }

     public void setPais(String pais) {
         this.pais = pais;
     }

     public void setPreco(double preco) {
         this.preco = preco;
     } 

     public void setCategoria(String categoria) {
        this.categoria = this.categoria.parseCategoriaVinho(categoria);
     } 
     public String  getCategoria() {
       if (this.categoria.ordinal() == 0) 
        return "Simples"; 
        else{ 
            if(this.categoria.ordinal() == 1) 
            return "Elaborado"; 
            else{ 
                if(this.categoria.ordinal() == 2) 
                return "Premium"; 
                else{ 
                    return null;
                }
            }
        }
     }


}