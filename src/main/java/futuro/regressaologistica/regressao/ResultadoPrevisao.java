package futuro.regressaologistica.regressao;

public class ResultadoPrevisao {
    private int resultado;
    private int tempoPagamento;
    private double valorTotalPagamento;

    // Construtor
    public ResultadoPrevisao(int resultado, int tempoPagamento, double valorTotalPagamento) {
        this.resultado = resultado;
        this.tempoPagamento = tempoPagamento;
        this.valorTotalPagamento = valorTotalPagamento;
    }

    // Getters e Setters
    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }

    public int getTempoPagamento() {
        return tempoPagamento;
    }

    public void setTempoPagamento(int tempoPagamento) {
        this.tempoPagamento = tempoPagamento;
    }

    public double getValorTotalPagamento() {
        return valorTotalPagamento;
    }

    public void setValorTotalPagamento(double valorTotalPagamento) {
        this.valorTotalPagamento = valorTotalPagamento;
    }
}
