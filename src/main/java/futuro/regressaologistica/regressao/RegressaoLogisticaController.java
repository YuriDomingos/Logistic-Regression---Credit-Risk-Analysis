package futuro.regressaologistica.regressao;

import futuro.regressaologistica.regressao.DadosPrevisao;
import futuro.regressaologistica.regressao.ResultadoPrevisao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/regressao-logistica")
public class RegressaoLogisticaController {
    private static final Logger logger = LoggerFactory.getLogger(RegressaoLogisticaController.class);

    @Autowired
    private RegressaoLogisticaService regressaoLogisticaService;

    // Endpoint para treinar o modelo
    @PostMapping("/treinar")
    public String treinarModelo(@RequestBody DadosTreinamento dados) {
        logger.info("Recebendo dados de treinamento: X={}, Y={}", dados.getX(), dados.getY());
        if (dados.getX() == null || dados.getY() == null) {
            throw new IllegalArgumentException("Os dados de treinamento X e Y não podem ser nulos");
        }
        regressaoLogisticaService.treinar(dados.getX(), dados.getY());
        return "Modelo treinado com sucesso!";
    }

    // Endpoint para prever se o cliente deve receber crédito
    @PostMapping("/prever")
    public ResultadoPrevisao prever(@RequestBody DadosPrevisao dados) {
        System.out.println("Valor " + dados.getX().toString());

        if (dados.getX() == null) {
            throw new IllegalArgumentException("Os dados de previsão X não podem ser nulos");
        }

        return regressaoLogisticaService.prever(dados.getX());
    }
}
