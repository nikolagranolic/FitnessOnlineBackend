package org.unibl.etf.fitnessonline.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.fitnessonline.models.entities.AttributeEntity;
import org.unibl.etf.fitnessonline.repositories.AttributeEntityRepository;

import java.util.List;

@RestController
@RequestMapping("/attributes")
public class AttributeController {
    private final AttributeEntityRepository repository;

    public AttributeController(AttributeEntityRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    List<AttributeEntity> findAll() {
        return repository.findAll();
    }
}
