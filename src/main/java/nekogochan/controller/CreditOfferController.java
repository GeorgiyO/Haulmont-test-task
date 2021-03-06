package nekogochan.controller;

import nekogochan.entity.CreditOffer;
import nekogochan.service.CreditOfferService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/credit-offers")
public class CreditOfferController extends DefaultEntityController<CreditOffer> {
    public CreditOfferController(CreditOfferService service) {
        super(service);
    }
}
