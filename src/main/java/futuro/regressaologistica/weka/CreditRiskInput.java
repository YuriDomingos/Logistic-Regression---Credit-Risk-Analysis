package futuro.regressaologistica.weka;

public class CreditRiskInput {
    private int idade;
    private String genero;
    private String estadoCivil;
    private double salario;
    private double receitas;
    private double despesas;
    private double valorSolicitado;
    private int historicoCredito;

    // Getters e setters

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getReceitas() {
        return receitas;
    }

    public void setReceitas(double receitas) {
        this.receitas = receitas;
    }

    public double getDespesas() {
        return despesas;
    }

    public void setDespesas(double despesas) {
        this.despesas = despesas;
    }

    public double getValorSolicitado() {
        return valorSolicitado;
    }

    public void setValorSolicitado(double valorSolicitado) {
        this.valorSolicitado = valorSolicitado;
    }

    public int getHistoricoCredito() {
        return historicoCredito;
    }

    public void setHistoricoCredito(int historicoCredito) {
        this.historicoCredito = historicoCredito;
    }
}
