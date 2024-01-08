package org.unibl.etf.fitnessonline.controllers;

import org.springframework.web.bind.annotation.*;
import org.unibl.etf.fitnessonline.models.dtos.AttributeDTO;
import org.unibl.etf.fitnessonline.services.AttributeService;

import java.util.List;

@RestController
@RequestMapping("/api/attributes")
@CrossOrigin(origins = "*")
public class AttributeController {
    private final AttributeService service;

    public AttributeController(AttributeService service) {
        this.service = service;
    }

    @GetMapping("/by-category/{id}")
    public List<AttributeDTO> getAllByCategoryId(@PathVariable Integer id) {
        return service.getAllAttributesByCategoryId(id);
    }
}
