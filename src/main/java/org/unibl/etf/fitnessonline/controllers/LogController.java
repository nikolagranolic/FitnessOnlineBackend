package org.unibl.etf.fitnessonline.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.fitnessonline.models.entities.LogEntity;
import org.unibl.etf.fitnessonline.repositories.LogEntityRepository;

import java.util.List;

@RestController
@RequestMapping("/logs")
public class LogController {
    private final LogEntityRepository repository;

    public LogController(LogEntityRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    List<LogEntity> findall() {
        return repository.findAll();
    }
}
