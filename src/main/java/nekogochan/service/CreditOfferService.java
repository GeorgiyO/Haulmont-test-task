package nekogochan.service;

import nekogochan.entity.CreditOffer;
import nekogochan.repository.CreditOfferRepository;
import nekogochan.repository.EntityNotFoundException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class CreditOfferService extends DefaultEntityService<CreditOffer> {

    public CreditOfferService(CreditOfferRepository repository) {
        super(repository, CreditOfferRepository.NotFoundException::new);
    }

}
