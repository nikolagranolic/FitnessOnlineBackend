package org.unibl.etf.fitnessonline.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.fitnessonline.models.entities.ProgramAttributeEntity;
import org.unibl.etf.fitnessonline.repositories.ProgramAttributeEntityRepository;

import java.util.List;

@RestController
@RequestMapping("/programAttributes")
public class ProgramAttributeController {
    private final ProgramAttributeEntityRepository repository;

    public ProgramAttributeController(ProgramAttributeEntityRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    List<ProgramAttributeEntity> findAll() {
        return repository.findAll();
    }
}
