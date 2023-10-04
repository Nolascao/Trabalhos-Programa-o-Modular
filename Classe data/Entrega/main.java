package data;

public class main {

	public static void main(String[] args) {
		Data minhaData = new Data();
		Data minhaData2 = new Data(5,11,2019); 
		//System.out.println(minhaData2.validarData()); 
		Data minhaData3 = new Data(10,11,2019); 
		//System.out.println(minhaData3.getDia());
		minhaData = minhaData2.maisFutura(minhaData3);  
		minhaData.dataFormatada();
	}

}
