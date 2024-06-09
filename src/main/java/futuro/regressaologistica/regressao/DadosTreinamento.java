package futuro.regressaologistica.regressao;

import com.fasterxml.jackson.annotation.JsonProperty;

class DadosTreinamento {
    @JsonProperty("X")
    private double[][] X;

    @JsonProperty("Y")
    private double[] Y;

    // Getters e Setters
    public double[][] getX() {
        return X;
    }

    public void setX(double[][] x) {
        X = x;
    }

    public double[] getY() {
        return Y;
    }

    public void setY(double[] y) {
        Y = y;
    }
}

class DadosPrevisao {
    @JsonProperty("X")
    private double[] X;

    // Getters e Setters
    public double[] getX() {
        return X;
    }

    public void setX(double[] x) {
        X = x;
    }
}
