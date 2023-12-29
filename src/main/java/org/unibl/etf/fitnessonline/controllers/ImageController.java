package org.unibl.etf.fitnessonline.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.fitnessonline.models.entities.ImageEntity;
import org.unibl.etf.fitnessonline.repositories.ImageEntityRepository;

import java.util.List;

@RestController
@RequestMapping("/images")
public class ImageController {
    private final ImageEntityRepository repository;

    public ImageController(ImageEntityRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    List<ImageEntity> findAll() {
        return repository.findAll();
    }
}
