package com.example.practic.controllers;

public class NotFoundException extends RuntimeException {
    NotFoundException(Long id) {
        super("Could not find " + id);
    }
}