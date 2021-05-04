package nekogochan.repository;

import nekogochan.entity.PaymentGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentGraphRepository extends JpaRepository<PaymentGraph, Long> {
}
