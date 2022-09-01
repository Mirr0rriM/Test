package com.example.practic.controllers;

import com.example.practic.models.Oak;
import com.example.practic.repositories.OakRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class OakController {
    private final OakRepository repository;

    public OakController(OakRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/oak")
    Iterable<Oak> all() {
        return repository.findAll();
    }

    @PostMapping("/oak")
    Oak newOak(@RequestBody Oak newOak) {  return repository.save(newOak); }

    @GetMapping("/oak/{id}")
    Oak one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException(id));
    }

    @PutMapping("/oak/{id}")
    Oak replace(@RequestBody Oak newObject, @PathVariable Long id) {
        return repository.findById(id)
                .map(object -> {
                    object.setAge(newObject.getAge());
                    object.setWidth(newObject.getWidth());
                    return repository.save(object);
                })
                .orElseGet(() -> {
                    newObject.setId(id);
                    return repository.save(newObject);
                });
    }

    @DeleteMapping("/oak/{id}")
    void deleteOak(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
