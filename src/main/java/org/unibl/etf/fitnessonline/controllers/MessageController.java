package org.unibl.etf.fitnessonline.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.unibl.etf.fitnessonline.models.dtos.MessageDTO;
import org.unibl.etf.fitnessonline.models.entities.UserEntity;
import org.unibl.etf.fitnessonline.models.requests.MessageRequest;
import org.unibl.etf.fitnessonline.services.MessageService;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
@CrossOrigin(origins = "*")
public class MessageController {
    @Autowired
    private MessageService service;

    @PostMapping
    public void sendMessage(Authentication authentication, @RequestBody MessageRequest request) {
        UserEntity user = (UserEntity) authentication.getPrincipal();
        request.setSenderId(user.getId());
        service.sendMessage(request);
    }

    @GetMapping("/{id}")
    public List<MessageDTO> getUnreadMessagesAndMarkAsRead(Authentication authentication, @PathVariable Integer id) {
        UserEntity user = (UserEntity) authentication.getPrincipal();
        id = user.getId();
        return service.getUnreadMessagesAndMarkAsRead(id);
    }
}
