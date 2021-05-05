package nekogochan.repository;

import nekogochan.entity.Bank;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends CrudRepository<Bank, Long> {

    class NotFoundException extends EntityNotFoundException {
        public NotFoundException(Long id) {
            super("Bank", id);
        }
    }
}
