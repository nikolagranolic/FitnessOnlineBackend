package org.unibl.etf.fitnessonline.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.fitnessonline.models.entities.CategoryEntity;
import org.unibl.etf.fitnessonline.repositories.CategoryEntityRepository;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryEntityRepository repository;

    public CategoryController(CategoryEntityRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    List<CategoryEntity> findAll() {
        return repository.findAll();
    }
}
