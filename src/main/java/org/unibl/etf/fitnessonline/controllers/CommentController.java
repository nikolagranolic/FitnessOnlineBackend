package org.unibl.etf.fitnessonline.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.unibl.etf.fitnessonline.models.dtos.CommentDTO;
import org.unibl.etf.fitnessonline.models.requests.CommentRequest;
import org.unibl.etf.fitnessonline.services.ProgramService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/comments")
public class CommentController {
    private final ProgramService programService;

    public CommentController(ProgramService programService) {
        this.programService = programService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CommentDTO insert(@RequestBody CommentRequest commentRequest) {
        return programService.insertComment(commentRequest);
    }

}
