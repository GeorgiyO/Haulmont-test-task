package nekogochan.service;

import nekogochan.entity.CreditOffer;
import nekogochan.entity.PaymentGraphElement;
import nekogochan.repository.CreditOfferRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;

@Service
public class CreditOfferService extends DefaultEntityService<CreditOffer> {

    public CreditOfferService(CreditOfferRepository repository) {
        super(repository, CreditOfferRepository.NotFoundException::new);
    }

    @Override
    public CreditOffer add(CreditOffer offer) {
        offer.getPaymentGraph().sort(Comparator.comparing(PaymentGraphElement::getDate));
        return super.add(offer);
    }
}
