package Curso; 


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AlunoTest { 

    static Aluno a;  
    static Curso c;

    @BeforeEach 
    public void init(){ 
        a = new Aluno(); 
        c = new Curso("Carpintaria", 100, 50.5);
    } 

    @Test 
    public void testarNome(){ 
        a.setNome("Matheus"); 
        assertEquals("Matheus", a.getNome());
    } 

    @Test 
    public void testarMatricula(){ 
        a.setMatricula(1234); 
        assertEquals(1234, a.getMatricula());
    }  

    @Test 
    public void testarQuantidadeCursos(){ 
        a.adicionarCurso("Primeiros Socorros",100,50.5); 
        assertEquals(1, a.getQuantidadeCurso());
    }  

    @Test 
    public void testarLimiteQuantidadeCursos(){ 
        a.adicionarCurso("Primeiros Socorros",100,50.5);  
        a.adicionarCurso("Primeiros Socorros",100,50.5); 
        a.adicionarCurso("Primeiros Socorros",100,50.5); 
        a.adicionarCurso("Primeiros Socorros",100,50.5); 
        a.adicionarCurso("Primeiros Socorros",100,50.5); 
        a.adicionarCurso("Primeiros Socorros",100,50.5); 
        a.adicionarCurso("Primeiros Socorros",100,50.5);
        a.adicionarCurso("Primeiros Socorros",100,50.5); 
        a.adicionarCurso("Primeiros Socorros",100,50.5);
        a.adicionarCurso("Primeiros Socorros",100,50.5);
        a.adicionarCurso("Primeiros Socorros",100,50.5);
        assertEquals(10, a.getQuantidadeCurso()); 
    }  

    @Test 
    public void testarValorTotal(){ 
        a.adicionarCurso("Primeiros Socorros",100,50.5); 
        System.out.println(a.getValorTotal()); 
        assertEquals(1600, a.getValorTotal());
    } 
    
    @Test 
    public void testarValorTotal2(){ 
        a.adicionarCurso("Primeiros Socorros",100,50.5);  
        System.out.println(a.getValorTotal()); 
        a.adicionarCurso("Primeiros Socorros",10,50.5); 
        System.out.println(a.getValorTotal());  
        a.adicionarCurso("Primeiros Socorros",20,50.5); 
        System.out.println(a.getValorTotal()); 
        assertEquals(2250, a.getValorTotal());
    }  

    @Test 
    public void testarValorTotal3(){ 
        a.adicionarCurso("Primeiros Socorros",100,50.5); 
        c = new Curso("Primeiros Socorros",100,50.5); 
        //System.out.println(c.toString());  //1600
        a.adicionarCurso("Primeiros Socorros",10,50.5); 
        c = new Curso("Primeiros Socorros",15,50.5); 
        //System.out.println(c.toString());  // 400
        a.adicionarCurso("Primeiros Socorros",20,50.5);  
        c = new Curso("Primeiros Socorros",20,50.5); //500
        //System.out.println(c.toString());  
        a.adicionarCurso("Primeiros Socorros",20,50.5); //500 
        a.adicionarCurso("Primeiros Socorros",20,50.5); //500
        assertEquals(3100, a.getValorTotal());
    }  

    @Test 
    public void testarDividirValorTotal(){ 
        a.adicionarCurso("Primeiros Socorros",100,50.5); 
        c = new Curso("Primeiros Socorros",100,50.5); 
        //System.out.println(c.toString());  //1600
        a.adicionarCurso("Primeiros Socorros",10,50.5); 
        c = new Curso("Primeiros Socorros",15,50.5); 
        //System.out.println(c.toString());  // 400
        a.adicionarCurso("Primeiros Socorros",20,50.5);  
        c = new Curso("Primeiros Socorros",20,50.5); //500
        //System.out.println(c.toString());  
        a.adicionarCurso("Primeiros Socorros",20,50.5); //500 
        a.adicionarCurso("Primeiros Socorros",20,50.5); //500
        assertEquals(3100, a.getValorTotal()); 
        a.dividirValor(10); 
        assertEquals(310, a.getValorParcelas());
    } 


   
}