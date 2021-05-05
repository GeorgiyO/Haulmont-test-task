package nekogochan.controller;

import nekogochan.entity.Bank;
import nekogochan.service.BankService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/banks")
public class BankController extends DefaultEntityController<Bank> {

    public BankController(BankService service) {
        super(service);
    }
}
