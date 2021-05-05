package nekogochan.controller;

import nekogochan.entity.Credit;
import nekogochan.service.CreditService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/credits")
public class CreditController extends DefaultEntityController<Credit> {
    public CreditController(CreditService service) {
        super(service);
    }
}
