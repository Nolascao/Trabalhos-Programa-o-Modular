package Curso; 

public class Aluno { 
    
    private String nome = new String();  
    private int matricula; 
    private int quantidadeCursos = 0; 
    private double valorTotal = 0;  
    private double valorMaisBarato = 1000000000;
    private Curso curso; 
    private int parcelas; 
    private double valorParcelas;

    public void setNome(String nome){ 
        this.nome = nome;
    } 

    public String  getNome(){ 
        return this.nome;
    } 

    public void setMatricula(int Matricula){ 
        this.matricula = Matricula;
    } 

    public int  getMatricula(){ 
        return this.matricula;
    }  

    public void adicionarCurso(String nome, int carga, double material){ 
        if (this.quantidadeCursos < 10){ 
            curso = new Curso(nome, carga, material); 
            //System.out.println("Valor total = " + curso.valorTotal());
            if (this.valorMaisBarato > curso.valorTotal()){ 
                this.valorMaisBarato = curso.valorTotal();
            } 
            curso.toString();  
            //System.out.println("Valor mais barato = " + this.valorMaisBarato);
            this.valorTotal += curso.valorTotal();
            this.quantidadeCursos++;
        }
    } 

    public int getQuantidadeCurso(){ 
        return this.quantidadeCursos;
    } 

    public double getValorTotal(){  
        //System.out.println("Quantidade Curso = " + this.quantidadeCursos);
        if (this.quantidadeCursos>=3 && this.quantidadeCursos<=4) 
            return this.valorTotal*0.9; 
        else{ 
            if(this.quantidadeCursos>=5) 
                return this.valorTotal - this.valorMaisBarato;  
            else { 
                return this.valorTotal;
            } 
            
        } 
    }  

    public void dividirValor(int parcelas){ 
        if (parcelas <=10 && (this.getValorTotal()/parcelas >=150)){ 
            this.parcelas = parcelas; 
            this.valorParcelas = this.getValorTotal()/parcelas;
        }
    }
        
    public double getValorParcelas(){ 
        return valorParcelas;
    } 

    public int getParcelas(){ 
        return parcelas;
    }



} 


   
