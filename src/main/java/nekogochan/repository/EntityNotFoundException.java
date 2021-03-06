package nekogochan.repository;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String entityName, Long id) {
        super(entityName + " with id = " + id + " not found");
    }
}
