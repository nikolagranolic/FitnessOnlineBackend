package org.unibl.etf.fitnessonline.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.fitnessonline.models.dtos.CategorySimpleDTO;
import org.unibl.etf.fitnessonline.services.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "*")
public class CategoryController {
    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping
    List<CategorySimpleDTO> findAll() {
        return service.findAll();
    }
}
