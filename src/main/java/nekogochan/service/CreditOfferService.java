package nekogochan.service;

import nekogochan.entity.CreditOffer;
import nekogochan.repository.CreditOfferRepository;
import org.springframework.stereotype.Service;

@Service
public class CreditOfferService extends DefaultEntityService<CreditOffer> {
    public CreditOfferService(CreditOfferRepository repository) {
        setRepository(repository);
        setNotFoundExceptionProvider(CreditOfferRepository.NotFoundException::new);
    }
}
