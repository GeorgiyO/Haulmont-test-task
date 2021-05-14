package nekogochan.service;

import nekogochan.entity.Credit;
import nekogochan.repository.CreditRepository;
import org.springframework.stereotype.Service;

@Service
public class CreditService extends DefaultEntityService<Credit> {

    public CreditService(CreditRepository repository) {
        super(repository, CreditRepository.NotFoundException::new);
    }
}
