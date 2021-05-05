package nekogochan.service;

import java.util.List;

public interface EntityService<Type> {
    Type get(Long id);
    List<Type> getAll();
    Type add(Type entity);
    Type update(Type entity, Long id);
    boolean delete(Long id);
}
