package nekogochan.repository;

import nekogochan.entity.PaymentGraphElement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentGraphRepository extends JpaRepository<PaymentGraphElement, Long> {

    class NotFoundException extends EntityNotFoundException {
        public NotFoundException(Long id) {
            super("Payment graph", id);
        }
    }

}
