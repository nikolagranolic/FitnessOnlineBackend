package org.unibl.etf.fitnessonline.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.fitnessonline.models.entities.CategorySubscriptionEntity;
import org.unibl.etf.fitnessonline.repositories.CategorySubscriptionEntityRepository;

import java.util.List;

@RestController
@RequestMapping("/subscriptions")
public class CategorySubscriptionController {
    private final CategorySubscriptionEntityRepository repository;

    public CategorySubscriptionController(CategorySubscriptionEntityRepository repository) {
        this.repository = repository;
    }

    List<CategorySubscriptionEntity> findAll() {
        return repository.findAll();
    }
}
