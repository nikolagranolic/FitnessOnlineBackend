package org.unibl.etf.fitnessonline.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.unibl.etf.fitnessonline.models.dtos.MessageDTO;
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
    public void sendMessage(@RequestBody MessageRequest request) {
        service.sendMessage(request);
    }

    @GetMapping("/{id}")
    public List<MessageDTO> getUnreadMessagesAndMarkAsRead(@PathVariable Integer id) {
        return service.getUnreadMessagesAndMarkAsRead(id);
    }
}
