package Calculadora;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculadoraTDD{ 
   static Calculadora c; 

   @BeforeEach
   public void init(){ 
       c = new Calculadora();
   } 

   @Test 
   public void testeElementoNuloMultiplicacao(){ 
       assertEquals(0.0, c.mul(10.0, 0.0));
   } 

   
   @Test 
   public void testeElementoNeutroAdicao(){ 
       assertEquals(10.0, c.som(10.0, 0.0));
   }
}