package com.example.practic.controllers;

import com.example.practic.models.Palm;
import com.example.practic.repositories.PalmRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class PalmController {
    private final PalmRepository repository;

    public PalmController(PalmRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/palm")
    Iterable<Palm> all() {
        return repository.findAll();
    }

    @PostMapping("/palm")
    Palm newPalm(@RequestBody Palm newPalm) {  return repository.save(newPalm); }

    @GetMapping("/palm/{id}")
    Palm one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException(id));
    }

    @PutMapping("/palm/{id}")
    Palm replace(@RequestBody Palm newObject, @PathVariable Long id) {
        return repository.findById(id)
                .map(object -> {
                    object.setCountOfFruits(newObject.getCountOfFruits());
                    return repository.save(object);
                })
                .orElseGet(() -> {
                    newObject.setId(id);
                    return repository.save(newObject);
                });
    }

    @DeleteMapping("/palm/{id}")
    void deletePalm(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
