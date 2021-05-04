package nekogochan.repository;

import nekogochan.domain.EntityNotFoundException;
import nekogochan.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {

    class NotFoundException extends EntityNotFoundException {
        public NotFoundException(Long id) {
            super("Bank", id);
        }
    }
}
