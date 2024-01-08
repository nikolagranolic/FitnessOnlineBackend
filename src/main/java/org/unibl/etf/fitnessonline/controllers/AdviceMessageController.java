package org.unibl.etf.fitnessonline.controllers;

import org.springframework.web.bind.annotation.*;
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
    public void sendAdviceMessage(@RequestBody AdviceMessageRequest request) {
        service.sendAdviceMessage(request);
    }
}
