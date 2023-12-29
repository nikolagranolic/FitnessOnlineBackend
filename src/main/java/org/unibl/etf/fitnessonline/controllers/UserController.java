package org.unibl.etf.fitnessonline.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.fitnessonline.models.entities.UserEntity;
import org.unibl.etf.fitnessonline.repositories.UserEntityRepository;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserEntityRepository repository;

    public UserController(UserEntityRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    List<UserEntity> findAll() {
        return repository.findAll();
    }
}
