package org.unibl.etf.fitnessonline.controllers;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.unibl.etf.fitnessonline.exceptions.BadRequestException;
import org.unibl.etf.fitnessonline.models.requests.ProgramAttributeRequest;
import org.unibl.etf.fitnessonline.services.ProgramAttributeService;

@RestController
@RequestMapping("/api/program-attributes")
@CrossOrigin(origins = "*")
public class ProgramAttributeController {
    private final ProgramAttributeService service;

    public ProgramAttributeController(ProgramAttributeService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addProgramAttribute(@RequestBody @Valid ProgramAttributeRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BadRequestException();
        }
        service.addProgramAttribute(request);
    }
}
