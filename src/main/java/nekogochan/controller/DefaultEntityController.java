package nekogochan.controller;

import nekogochan.service.EntityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class DefaultEntityController<Entity> {

    private final EntityService<Entity> service;

    public DefaultEntityController(EntityService<Entity> service) {
        this.service = service;
    }

    @GetMapping
    public List<Entity> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Entity getOne(@PathVariable Long id) {
        return service.get(id);
    }

    @PostMapping
    public Entity add(@RequestBody Entity entity) {
        return service.add(entity);
    }

    @PutMapping("/{id}")
    public Entity update(@RequestBody Entity newEntity, @PathVariable Long id) {
        return service.update(newEntity, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
