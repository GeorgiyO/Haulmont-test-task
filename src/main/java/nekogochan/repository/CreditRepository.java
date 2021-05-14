package nekogochan.repository;

import nekogochan.entity.Credit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface CreditRepository extends JpaRepository<Credit, Long> {

    class NotFoundException extends EntityNotFoundException {
        public NotFoundException(Long id) {
            super("Credit", id);
        }
    }

    @Transactional
    void deleteByBankId(Long bankId);
}
