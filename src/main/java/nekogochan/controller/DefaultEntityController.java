package nekogochan.controller;

import nekogochan.service.EntityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class DefaultEntityController<Type> {

    private final EntityService<Type> service;

    public DefaultEntityController(EntityService<Type> service) {
        this.service = service;
    }

    @GetMapping
    public List<Type> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Type getOne(@PathVariable Long id) {
        return service.get(id);
    }

    @PostMapping
    public Type add(@RequestBody Type entity) {
        return service.add(entity);
    }

    @PutMapping("/{id}")
    public Type update(@RequestBody Type newEntity, @PathVariable Long id) {
        return service.update(newEntity, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
