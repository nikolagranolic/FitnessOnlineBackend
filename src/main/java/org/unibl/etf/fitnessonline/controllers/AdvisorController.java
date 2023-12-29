package org.unibl.etf.fitnessonline.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.fitnessonline.models.entities.AdvisorEntity;
import org.unibl.etf.fitnessonline.repositories.AdvisorEntityRepository;

import java.util.List;

@RestController
@RequestMapping("/advisors")
public class AdvisorController {
    private final AdvisorEntityRepository repository;

    public AdvisorController(AdvisorEntityRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    List<AdvisorEntity> findAll() {
        return repository.findAll();
    }
}
