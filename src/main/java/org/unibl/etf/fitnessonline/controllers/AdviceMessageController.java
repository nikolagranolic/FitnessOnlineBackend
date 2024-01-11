package org.unibl.etf.fitnessonline.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.unibl.etf.fitnessonline.models.entities.UserEntity;
import org.unibl.etf.fitnessonline.models.requests.AdviceMessageRequest;
import org.unibl.etf.fitnessonline.services.AdviceMessageService;

@RestController
@RequestMapping("/api/advice-messages")
@CrossOrigin(origins = "*")
public class AdviceMessageController {
    private final AdviceMessageService service;

    public AdviceMessageController(AdviceMessageService service) {
        this.service = service;
    }

    @PostMapping
    public void sendAdviceMessage(Authentication authentication, @RequestBody AdviceMessageRequest request) {
        UserEntity user = (UserEntity) authentication.getPrincipal();
        request.setSender(user.getId());
        service.sendAdviceMessage(request);
    }
}
