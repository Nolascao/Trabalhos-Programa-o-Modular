public class cadastrado implements INivelCliente  {
    private double valorMensalidade; 
    protected static double DESCONTO_COMPRA = 1; 

    @Override
    public double valorAPagarCompra(compra Compra) {
        
        return Compra.calcValorTotal() * DESCONTO_COMPRA;
    } 

    @Override
    public double valorProdutosCompra(vinho Qual) {
        
        return Qual.getPreco(); 
    } 

    @Override
    public double valorFreteCompra(compra Compra) {
        
        return Compra.calcValorFrete();
    } 

    @Override
    public double consultaVinho(vinho Qual) {
        
        return Qual.getPreco();
    } 
    @Override
    public double getMensalidade() {
        
        return this.valorMensalidade;
    } 

    public void setValorMensalidade() {
        this.valorMensalidade = 0;
    } 

}
