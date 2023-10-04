public class vip implements INivelCliente { 
    private double valorMensalidade; 
    protected static double DESCONTO_COMPRA = 0.7; 
    protected static double DESCONTO_FRETE; 

    @Override
    public double valorAPagarCompra(compra Compra) { 
        DESCONTO_FRETE = Compra.calcValorFrete();
        return (Compra.calcValorTotal() * DESCONTO_COMPRA) - DESCONTO_FRETE;
    }  

    @Override
    public double valorFreteCompra(compra Compra) {
        return 0;
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
