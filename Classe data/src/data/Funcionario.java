package data;

public class Funcionario { 

    private double salarioBase; 
    private int horasExtras; 
    private Data data = new Data(); 

    public double getSalarioBase(){ 
        return salarioBase;
    }  

    public void setSalarioBase(double salario){ 
        this.salarioBase = salario;
    } 

    public double getHorasExtras(){ 
        return horasExtras;
    }  

    public void setHorasExtras(int horas){ 
        this.horasExtras = horas;
    }

    public double salarioLiquido(){ 
    //O salário líquido é a soma do salário base,  
    //mais o valor das horas extras, menos o valor do vale transporte; 
        return (this.getSalarioBase() + (this.getHorasExtras()*this.valorHorasExtras()) - this.valorValeTransporte(4.50));
    }

    public void reajustarSalario(double porcentagem){ 
        this.setSalarioBase((this.getSalarioBase() * porcentagem));
    } 

    public double decimoTerceiro(){ 
       // O décimo terceiro salário é calculado  
       //como a proporção do salário base em relação aos meses  
       //trabalhados no ano atual. Um mês é considerado trabalhado  
       //se a admissão do funcionário se deu até o dia 15 deste mês. 
       if (data.getDia()<15) {
            double decimoTerceiro = this.getSalarioBase()/data.getMes();
            return decimoTerceiro; 
        } 
        else{ 
            return 0;
        }
       
    } 

    private double valorHorasExtras(){ 
      //Cada hora extra vale 1/90 do salário base; 
        return (this.getSalarioBase()/90); 
    } 

    private double valorValeTransporte (double valPassagem){ 
      //O vale transporte é descontado como 44 passagens ou 6%  
      //do salário base (dentre estes dois valores, o que for menor); 
        if ((valPassagem * 44) < (this.getSalarioBase()*0.06)) 
            return (valPassagem * 44); 
        else{ 
            return (this.getSalarioBase()*0.06);
        }

    }
    
}
