package org.unibl.etf.fitnessonline.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.fitnessonline.models.entities.ActivityEntity;
import org.unibl.etf.fitnessonline.repositories.ActivityEntityRepository;

import java.util.List;

@RestController
@RequestMapping("/activities")
public class ActivityController {

    private final ActivityEntityRepository repository;

    public ActivityController(ActivityEntityRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    List<ActivityEntity> findAll() {
        return repository.findAll();
    }
}
