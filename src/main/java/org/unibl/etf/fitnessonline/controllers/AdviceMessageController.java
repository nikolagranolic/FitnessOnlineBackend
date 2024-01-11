package org.unibl.etf.fitnessonline.controllers;

import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.unibl.etf.fitnessonline.exceptions.BadRequestException;
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
    public void sendAdviceMessage(Authentication authentication, @RequestBody @Valid AdviceMessageRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BadRequestException();
        }
        UserEntity user = (UserEntity) authentication.getPrincipal();
        request.setSender(user.getId());
        service.sendAdviceMessage(request);
    }
}
