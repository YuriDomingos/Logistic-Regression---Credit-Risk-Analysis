package futuro.regressaologistica.weka;

import weka.classifiers.Classifier;
import weka.classifiers.functions.Logistic;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

import java.util.ArrayList;
import java.util.List;

public class CreditRiskModel {
    private Classifier classifier;
    private Instances datasetStructure;

    public CreditRiskModel() throws Exception {

        DataSource source = new DataSource("src/main/resources/dados.arff");
        System.out.println("CHEGGUEII");
        Instances dataset = source.getDataSet();

        dataset.setClassIndex(dataset.numAttributes() - 1);

        classifier = new Logistic();
        classifier.buildClassifier(dataset);


        datasetStructure = new Instances(dataset, 0);
    }

    public double prever(CreditRiskInput input) throws Exception {
        // Criar uma nova instância para previsão
        DenseInstance instance = new DenseInstance(datasetStructure.numAttributes());
        instance.setDataset(datasetStructure);


        instance.setValue(0, input.getIdade());
        instance.setValue(1, input.getGenero());
        instance.setValue(2, input.getEstadoCivil());
        instance.setValue(3, input.getSalario());
        instance.setValue(4, input.getReceitas());
        instance.setValue(5, input.getDespesas());
        instance.setValue(6, input.getValorSolicitado());
        instance.setValue(7, input.getHistoricoCredito());

        // Fazer a previsão
        double prediction = classifier.classifyInstance(instance);
        return prediction;
    }
}
