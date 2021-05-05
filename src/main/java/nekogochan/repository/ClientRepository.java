package nekogochan.repository;

import nekogochan.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    class NotFoundException extends EntityNotFoundException {
        public NotFoundException(Long id) {
            super("Client", id);
        }
    }
}
