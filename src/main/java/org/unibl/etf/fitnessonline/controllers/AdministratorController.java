package org.unibl.etf.fitnessonline.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.fitnessonline.models.entities.AdministratorEntity;
import org.unibl.etf.fitnessonline.repositories.AdministratorEntityRepository;

import java.util.List;

@RestController
@RequestMapping("/administrators")
public class AdministratorController {
    private final AdministratorEntityRepository repository;

    public AdministratorController(AdministratorEntityRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    List<AdministratorEntity> findAll() {
        return repository.findAll();
    }
}
