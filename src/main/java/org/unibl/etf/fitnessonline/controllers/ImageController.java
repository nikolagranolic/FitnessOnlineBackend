package org.unibl.etf.fitnessonline.controllers;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.unibl.etf.fitnessonline.exceptions.BadRequestException;
import org.unibl.etf.fitnessonline.models.requests.ImageRequest;
import org.unibl.etf.fitnessonline.services.ImageService;

@RestController
@RequestMapping("/api/images")
@CrossOrigin(origins = "*")
public class ImageController {
    private final ImageService service;

    public ImageController(ImageService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void insertImage(@RequestBody @Valid ImageRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BadRequestException();
        }
        service.insertImage(request);
    }
}
