package org.unibl.etf.fitnessonline.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.fitnessonline.models.entities.MessageEntity;
import org.unibl.etf.fitnessonline.repositories.MessageEntityRepository;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {
    private final MessageEntityRepository repository;

    public MessageController(MessageEntityRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    List<MessageEntity> findAll() {
        return repository.findAll();
    }
}
