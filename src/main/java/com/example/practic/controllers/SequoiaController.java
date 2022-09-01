package com.example.practic.controllers;

import com.example.practic.models.Sequoia;
import com.example.practic.repositories.SequoiaRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class SequoiaController {
    private final SequoiaRepository repository;

    public SequoiaController(SequoiaRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/sequoia")
    Iterable<Sequoia> all() {
        return repository.findAll();
    }

    @PostMapping("/sequoia")
    Sequoia newSequoia(@RequestBody Sequoia newSequoia) {  return repository.save(newSequoia); }

    @GetMapping("/sequoia/{id}")
    Sequoia one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException(id));
    }

    @PutMapping("/sequoia/{id}")
    Sequoia replace(@RequestBody Sequoia newObject, @PathVariable Long id) {
        return repository.findById(id)
                .map(object -> {
                    object.setAge(newObject.getAge());
                    object.setHeight(newObject.getHeight());
                    return repository.save(object);
                })
                .orElseGet(() -> {
                    newObject.setId(id);
                    return repository.save(newObject);
                });
    }

    @DeleteMapping("/sequoia/{id}")
    void deleteSequoia(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
