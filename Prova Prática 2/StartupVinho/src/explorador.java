public class explorador implements INivelCliente{
    private double valorMensalidade; 
    protected static double DESCONTO_COMPRA = 0.9; 

    @Override
    public double valorAPagarCompra(compra Compra) {
        return Compra.calcValorTotal() * DESCONTO_COMPRA;
    } 

    @Override
    public double valorFreteCompra(compra Compra) {
        return Compra.calcValorFrete();
    } 

    @Override
    public double valorProdutosCompra(vinho Qual) {
        return Qual.getPreco();
    } 

    @Override
    public double consultaVinho(vinho Qual) {
        return Qual.getPreco();
    } 

    @Override
    public double getMensalidade() {
        return this.valorMensalidade;
    } 

    public void setValorMensalidade(double valorMensalidade) {
        this.valorMensalidade = valorMensalidade;
    }
}
