package org.unibl.etf.fitnessonline.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.fitnessonline.models.entities.ProgramParticipationEntity;
import org.unibl.etf.fitnessonline.repositories.ProgramParticipationEntityRepository;

import java.util.List;

@RestController
@RequestMapping("/participations")
public class ProgramParticipationController {
    private final ProgramParticipationEntityRepository repository;

    public ProgramParticipationController(ProgramParticipationEntityRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    List<ProgramParticipationEntity> findAll() {
        return repository.findAll();
    }
}
