package nekogochan.service;

import nekogochan.entity.Credit;
import nekogochan.repository.CreditRepository;
import org.springframework.stereotype.Service;

@Service
public class CreditService extends DefaultEntityService<Credit> {

    private final CreditRepository repository;

    public CreditService(CreditRepository repository) {
        setNotFoundExceptionProvider(CreditRepository.NotFoundException::new);
        this.repository = repository;
    }

    public void deleteByBankId(Long bankId) {
        repository.deleteByBankId(bankId);
    }
}
