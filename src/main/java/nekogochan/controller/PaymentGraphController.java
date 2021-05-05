package nekogochan.controller;

import nekogochan.entity.PaymentGraph;
import nekogochan.service.PaymentGraphService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment-graphs")
public class PaymentGraphController extends DefaultEntityController<PaymentGraph> {
    public PaymentGraphController(PaymentGraphService service) {
        super(service);
    }
}
