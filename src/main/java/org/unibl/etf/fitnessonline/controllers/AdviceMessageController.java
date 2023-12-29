package org.unibl.etf.fitnessonline.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.fitnessonline.models.entities.AdviceMessageEntity;
import org.unibl.etf.fitnessonline.repositories.AdviceMessageEntityRepository;

import java.util.List;

@RestController
@RequestMapping("/adviceMessages")
public class AdviceMessageController {
    private final AdviceMessageEntityRepository repository;

    public AdviceMessageController(AdviceMessageEntityRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    List<AdviceMessageEntity> findAll() {
        return repository.findAll();
    }
}
