package nekogochan.service;

import nekogochan.entity.PaymentGraph;
import nekogochan.repository.PaymentGraphRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentGraphService extends DefaultEntityService<PaymentGraph> {
    public PaymentGraphService(PaymentGraphRepository repository) {
        super(repository, PaymentGraphRepository.NotFoundException::new);
    }
}
