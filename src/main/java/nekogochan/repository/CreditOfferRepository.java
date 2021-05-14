package nekogochan.repository;

import nekogochan.entity.CreditOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditOfferRepository extends JpaRepository<CreditOffer, Long> {

    class NotFoundException extends EntityNotFoundException {
        public NotFoundException(Long id) {
            super("Credit offer", id);
        }
    }

    void deleteByCreditId(Long id);
}
