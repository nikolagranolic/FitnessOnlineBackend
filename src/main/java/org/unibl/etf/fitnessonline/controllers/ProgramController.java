package org.unibl.etf.fitnessonline.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.fitnessonline.models.entities.ProgramEntity;
import org.unibl.etf.fitnessonline.repositories.ProgramEntityRepository;

import java.util.List;

@RestController
@RequestMapping("/programs")
public class ProgramController {
    private final ProgramEntityRepository repository;

    public ProgramController(ProgramEntityRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    List<ProgramEntity> findAll() {
        return repository.findAll();
    }
}
