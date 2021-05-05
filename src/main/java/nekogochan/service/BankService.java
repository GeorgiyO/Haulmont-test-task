package nekogochan.service;

import nekogochan.entity.Bank;
import nekogochan.repository.BankRepository;
import org.springframework.stereotype.Service;

@Service
public class BankService extends DefaultEntityService<Bank> {
    public BankService(BankRepository repository) {
        super(repository, BankRepository.NotFoundException::new);
    }
}
