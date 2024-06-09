package futuro.regressaologistica.regressao;

import java.util.Random;

public class RegressaoLogistica {

    private int numFeatures;
    private double taxaAprendizado;
    private int iteracoes;
    private double[] pesos;

    public RegressaoLogistica(int numFeatures, double taxaAprendizado, int iteracoes) {
        this.numFeatures = numFeatures + 1; // Adiciona 1 para o termo de polarização
        this.taxaAprendizado = taxaAprendizado;
        this.iteracoes = iteracoes;
        this.pesos = new double[this.numFeatures];
        // Inicializa os pesos aleatoriamente
        Random rand = new Random();
        for (int i = 0; i < this.numFeatures; i++) {
            this.pesos[i] = rand.nextDouble();
        }
    }
    public void treinar(double[][] X, double[] y) {
        for (int iteracao = 0; iteracao < iteracoes; iteracao++) {
            for (int i = 0; i < X.length; i++) {
                double[] entrada = new double[numFeatures];
                entrada[0] = 1; // Bias
                for (int j = 0; j < numFeatures - 1; j++) {
                    if (j < X[i].length) {
                        entrada[j + 1] = X[i][j];
                    }
                }
                double erro = y[i] - prever(entrada);
                for (int j = 0; j < numFeatures; j++) {
                    pesos[j] += taxaAprendizado * erro * entrada[j];
                }
            }
            System.out.println("Iteração " + (iteracao + 1) + ", Erro: " + calcularErro(X, y));
        }
    }


    public double prever(double[] x) {
        if (x.length != numFeatures) {
            throw new IllegalArgumentException("O comprimento do vetor de entrada deve ser igual a " + numFeatures);
        }

        double logit = 0;
        for (int i = 0; i < numFeatures; i++) {
            logit += pesos[i] * x[i];
        }
        return sigmoid(logit);
    }
    private double sigmoid(double z) {
        return 1 / (1 + Math.exp(-z));
    }

    private double calcularErro(double[][] X, double[] y) {
        double erroTotal = 0;
        for (int i = 0; i < X.length; i++) {
            double[] entrada = new double[numFeatures];
            entrada[0] = 1; // Bias
            for (int j = 0; j < numFeatures - 1; j++) {
                entrada[j + 1] = X[i][j];
            }
            double erro = y[i] - prever(entrada);
            erroTotal += Math.pow(erro, 2);
        }
        return erroTotal / (2 * X.length);
    }
}
