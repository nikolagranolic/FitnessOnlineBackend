package org.unibl.etf.fitnessonline.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
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
    void insertImage(@RequestBody ImageRequest request) {
        service.insertImage(request);
    }
}
