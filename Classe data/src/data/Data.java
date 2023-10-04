package data;


/* 
 * AUTOR: Matheus Nolasco Miranda Soares
 * DATA: 28/02/2022
 * 
 * */


class Data {
    private int dia; 
    private int mes; 
    private int ano; 
    
    public int getDia() { 
    	return dia;
    } 
    public void setDia(int dia) { 
    	this.dia = dia;
    }
	
    public int getMes() { 
    	return mes;
    } 
    public void setMes(int mes) { 
    	this.mes = mes;
    }
    
    public int getAno() { 
    	return ano;
    } 
    public void setAno(int ano) { 
    	this.ano = ano;
    } 
    
    private void init(int dia, int mes, int ano){
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.validarData();
    }
    
    public Data(int dia, int mes, int ano){
        this.init(dia, mes, ano);
    }  
    
    public Data(){
        this.init(1,1,1900);
    }
    
    /* 
     * anoExercicio() : boolean
     * 
     * Metodo usado na funcao diaMax() para determinar se o ano e ou nao bissexto
     * e, logo, se o mes de fevereiro tem 28 ou 29 dias.
     * 
     * */
    public boolean anoBissexto() { 
    	if ((this.ano % 4) == 0 ) 
    		return true;
    		else { 
    			return false;
    		}
    }
    
    /* 
     * diaMax() : int
     * 
     * Metodo usado nas funcoes validarData e adicionarDias para determinar quantos dias 
     * um mes determinado tem.
     * 
     * */
    
    public int diaMax() { 
    	if(this.mes == 1 || this.mes == 3 || this.mes == 5 || this.mes == 7 || this.mes == 8 || this.mes == 10 || this.mes == 12) {
    		return 31; 
    	}
    	else { 
    		if (this.mes == 4 || this.mes == 6 || this.mes == 9 || this.mes == 11) { 
    			return 30; 
    		} else { 
    			if (this.mes == 2) { 
    				if (this.anoBissexto() == true) 
    					return 29; 
    				else { 
    					return 28;
    				} 
    			}
    		}
    	}  
    	return 0;
    }
    
    /* 
     * validarData() : boolean
     * 
     * Metodo utilizado para determinar se uma data e valida ou nao.
     * 
     * */
    
    
    public boolean validarData() { 
    	if (this.ano>0){ 
    		if (this.mes > 0 && this.mes < 13){ 
    			if (this.dia > 0 && this.dia <= (diaMax())  ) { 
    				return true;
    			} 
    			else { 
    				return false;
    			} 	
    		} 
    		else { 
    			return false;
    		} 
    	}
    	else { 
    		return false;
    	}
    		
    		
    } 
   
    /* 
     * adicionarDias(dia:int) : Data
     * 
     * Metodo utilizado para adicionar dias a uma data e formata-la novamente;
     * 
     * */
    
    public Data adicionarDias(int dia) { 
    	this.dia = this.dia + dia; 
    	if (this.dia > (diaMax())) {  //Quantidade de dias ultrapassou o maximo do mes
    		while (this.dia > (diaMax()) ) { 
    		  if(this.mes < 13) {
    		  this.dia -= diaMax();  
    		  this.mes +=1;  
    		  } 
    		  else { 
    			  this.mes = 1; 
                  this.ano +=1; 
                  
    		  }
    	  } 
    	
    	}   
    	Data minhaData = new Data(this.dia,this.mes,this.ano);
    	return minhaData;
    }
    
    /* 
     * maisAntiga(minhaData:Data) : Data
     * 
     * Metodo utilizado para comparar duas datas e comparar qual e a mais antiga.
     * 
     * */
    
    
     

	public Data maisFutura(Data minhaData){ 
        if(this.getAno()> minhaData.getAno()) 
		 	return this;
		else{   
			if(this.getAno() < minhaData.getAno())
				return minhaData; 
			else{     		
				if(this.getAno() == minhaData.getAno()){ 
			   		if(this.getMes() > minhaData.getMes()) 
			   			return this; 
			  		else{     
			   			if(this.getMes() < minhaData.getMes()) 
			   				return minhaData; 
			  			 else{ 
			   				if (this.getMes() == minhaData.getMes()){
			   					if (this.getDia() > minhaData.getDia()) 
					   				return this; 
								else{ 
									if(this.getDia() < minhaData.getDia()) 
										return minhaData; 
									else{     
										if(this.getDia() == minhaData.getDia()) 
											return this;   
									} 
								} 
							}  
						}
					}
				}
			}  
			return this;
		}
			   
	}  

    	
    /* 
     * dataFormatada() : void
     * 
     * Metodo utilizado para mostrar a data formatada da classe.
     * 
     * */
    
    public void dataFormatada() { 
    	if (this.dia < 10) { 
    		System.out.print("0"+this.dia+"/");
    	} 
    	else { 
    		System.out.print(this.dia+"/");
    	} 
    	if (this.mes < 10) { 
    		System.out.print("0"+this.mes+"/");
    	} 
    	else { 
    		System.out.print(this.mes+"/");
    	} 
    	System.out.print(this.ano);
    }
    
	
}
