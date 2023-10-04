package Curso;
/**
 * Classe para cursos online
 */
public class Curso {
    private static final int MIN_CARGA = 15;
    private static final int MAX_CARGA = 150;
    private static final double MIN_MATERIAL = 100d;
    private static final double HORA_BASE = 20d;
    private String nome;
    private int cargaHoraria;
    private double valorHoraAula;
    private double custoMaterial;

    /**
     * Configura carga horária, valor da hora e material. Método privado
     * @param carga Carga horária suposta para o curso
     * @param material Valor suposto do material para o curso
     */
    private void init(int carga, double material){
        this.cargaHoraria = carga;
        if(carga<MIN_CARGA)
            this.cargaHoraria = MIN_CARGA;
        else if(carga > MAX_CARGA)
            this.cargaHoraria = MAX_CARGA;
        
        if(this.cargaHoraria<MAX_CARGA/3)
            this.valorHoraAula = HORA_BASE;
        else if(this.cargaHoraria<(MAX_CARGA*2/3))
            this.valorHoraAula = HORA_BASE*0.875;
        else
            this.valorHoraAula = HORA_BASE*0.75;

        this.custoMaterial = material;
        if(material<MIN_MATERIAL)
            this.custoMaterial = MIN_MATERIAL;

    }

    /**
     * Construtor: recebe nome, carga horária e valor do material
     * @param nome Nome do curso (sem validação)
     * @param carga Carga horária (será validada internamente)
     * @param material Valor do material (será validado internamente)
     */
    public Curso(String nome, int carga, double material){
        this.nome = nome;
        this.init(carga, material);
    }

    /**
     * Valor total do curso (contando aulas e material)
     * @return Valor total (double)
     */
    public double valorTotal(){
        return this.cargaHoraria*this.valorHoraAula+this.custoMaterial;
    }

    /**
     * Descrição do curso em string: nome, carga horária e valor total
     */
    @Override
    public String toString(){
        StringBuilder aux = new StringBuilder("Curso: "+this.nome+"\n");

        aux.append("Carga horária: "+this.cargaHoraria+"horas. \n");
        aux.append("Valor do curso: R$"+String.format("%.2f", this.valorTotal()));

        return aux.toString();
    }
}
