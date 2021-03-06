package nekogochan.service;

import nekogochan.entity.EntityI;
import nekogochan.repository.ClientRepository;
import nekogochan.repository.EntityNotFoundException;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.function.Function;

public class DefaultEntityService<Type extends EntityI> implements EntityService<Type> {

    protected final CrudRepository<Type, Long> repository;
    protected final Function<Long, EntityNotFoundException> notFoundExceptionProvider;

    public DefaultEntityService(CrudRepository<Type, Long> repository, Function<Long, EntityNotFoundException> notFoundExceptionProvider) {
        this.repository = repository;
        this.notFoundExceptionProvider = notFoundExceptionProvider;
    }

    @Override
    public Type get(Long id) {
        return repository
            .findById(id)
            .orElseThrow(() -> notFoundExceptionProvider.apply(id));
    }

    @Override
    public List<Type> getAll() {
        return (List<Type>) repository.findAll();
    }

    @Override
    public Type add(Type entity) {
        return repository.save(entity);
    }

    @Override
    public Type update(Type entity, Long id) {
        return repository.findById(id)
                         .map((e) -> {
                             entity.setId(id);
                             return repository.save(entity);
                         })
                         .orElseThrow(() -> notFoundExceptionProvider.apply(id));
    }

    @Override
    public boolean delete(Long id) {
        try {
            repository.findById(id)
                      .orElseThrow(() -> notFoundExceptionProvider.apply(id));
        } catch (ClientRepository.NotFoundException ignored) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }
}
