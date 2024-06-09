package futuro.regressaologistica.weka;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/credit-risk")
public class CreditRiskController {
    private CreditRiskModel creditRiskModel;

    public CreditRiskController() throws Exception {
        this.creditRiskModel = new CreditRiskModel();
    }

    @PostMapping("/analyze")
    public ResponseEntity<Double> analyzeCreditRisk(@RequestBody CreditRiskInput input) {
        try {
            double prediction = creditRiskModel.prever(input);
            return ResponseEntity.ok(prediction);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }
}
