package nekogochan.controller;

import nekogochan.entity.Bank;
import nekogochan.repository.BankRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/banks")
public class BankController {

    private final BankRepository repository;

    public BankController(BankRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Bank> all() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Bank one(@PathVariable Long id) {
        return repository
            .findById(id)
            .orElseThrow(() -> new BankRepository.NotFoundException(id));
    }

    @PostMapping
    public Bank add(@RequestBody Bank bank) {
        return repository.save(bank);
    }

    @PutMapping("/{id}")
    public Bank replace(@RequestBody Bank newBank, @PathVariable Long id) {
        return repository.findById(id)
            .map((bank) -> {
                bank.setName(newBank.getName());
                return repository.save(bank);
            })
            .orElseGet(() -> {
                newBank.setId(id);
                return repository.save(newBank);
            });
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
