package nekogochan.service;

import nekogochan.entity.Bank;
import nekogochan.repository.BankRepository;
import org.springframework.stereotype.Service;

@Service
public class BankService extends DefaultEntityService<Bank> {

    private final CreditService creditService;

    public BankService(BankRepository repository, CreditService creditService) {
        setRepository(repository);
        setNotFoundExceptionProvider(BankRepository.NotFoundException::new);
        this.creditService = creditService;
    }

    @Override
    public boolean delete(Long id) {
        creditService.deleteByBankId(id);
        return super.delete(id);
    }
}
