package futuro.regressaologistica.regressao;

import org.springframework.stereotype.Service;

/**
 * Serviço para Regressão Logística.
 */
@Service
public class RegressaoLogisticaService {
    private RegressaoLogistica regressaoLogistica;

    /**
     * Inicializa o serviço com os parâmetros do modelo de regressão logística.
     */
    public RegressaoLogisticaService() {
        int numFeatures = 9; // número de atributos (gênero, estado civil, salário, receitas, despesas, histórico de crédito, valor do produto, tempo de pagamento, taxa de juro)
        double taxaAprendizado = 0.01;
        int iteracoes = 1000;

        this.regressaoLogistica = new RegressaoLogistica(numFeatures, taxaAprendizado, iteracoes);
    }

    /**
     * Método para treinar o modelo de regressão logística.
     *
     * @param X Matriz de entrada contendo os atributos.
     * @param y Vetor de saída contendo os rótulos.
     */
    public void treinar(double[][] X, double[] y) {
        regressaoLogistica.treinar(X, y);
    }

    /**
     * Método para fazer previsões com o modelo treinado.
     *
     * @param x Vetor de entrada contendo os atributos do novo exemplo.
     * @return Resultado da previsão.
     */
// Método para fazer previsões
    // Método para fazer previsões
    public ResultadoPrevisao prever(double[] x) {
        double logit = regressaoLogistica.prever(x);

        // Aplicar a função sigmoid para obter a probabilidade
        double probabilidade = 1 / (1 + Math.exp(-logit));

        // Transformar a probabilidade em uma previsão binária (0 ou 1) com base em um limite de decisão (0.5)
        int resultado = probabilidade >= 0.5 ? 1 : 0;

        // Calcula o valor total do pagamento
        int tempoPagamento = (int) x[7];
        double valorProduto = x[6];
        double taxaJuro = x[8];
        double valorTotalPagamento = valorProduto * Math.pow(1 + taxaJuro, tempoPagamento / 12.0);

        // Lógica adicional para avaliar se o crédito deve ser negado
        boolean historicoCreditoRuim = x[5] > 1; // Histórico de crédito ruim
        double receitaLiquida = x[3] - x[4]; // Receitas - Despesas
        double taxaEsforco = valorProduto / receitaLiquida;

        if (historicoCreditoRuim || receitaLiquida < 1000 || taxaEsforco > 0.4) {
            resultado = 0; // Não conceder crédito
        }

        return new ResultadoPrevisao(resultado, tempoPagamento, valorTotalPagamento);
    }



    /**
     * Método auxiliar para determinar se o crédito deve ser negado com base em regras adicionais.
     *
     * @param x Vetor de entrada contendo os atributos do novo exemplo.
     * @return true se o crédito deve ser negado, false caso contrário.
     */
    private boolean deveNegarCredito(double[] x) {
        // Histórico de crédito ruim
        boolean historicoCreditoRuim = x[5] > 1;
        // Receita líquida insuficiente
        double receitaLiquida = x[3] - x[4]; // Receitas - Despesas
        // Taxa de esforço alta (valor do produto / receita líquida)
        double taxaEsforco = x[6] / receitaLiquida;

        // Condições para negar o crédito
        return historicoCreditoRuim || receitaLiquida < 1000 || taxaEsforco > 0.4;
    }
}
