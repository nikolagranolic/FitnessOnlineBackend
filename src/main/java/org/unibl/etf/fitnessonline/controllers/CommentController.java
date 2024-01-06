package org.unibl.etf.fitnessonline.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.unibl.etf.fitnessonline.models.dtos.CommentDTO;
import org.unibl.etf.fitnessonline.models.requests.CommentRequest;
import org.unibl.etf.fitnessonline.services.ProgramService;

@RestController
@RequestMapping("/api/comments")
@CrossOrigin(origins = "*")
public class CommentController {
    private final ProgramService programService;

    public CommentController(ProgramService programService) {
        this.programService = programService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public CommentDTO insert(@RequestBody CommentRequest commentRequest) {
        System.out.println("Received comment request");
        return programService.insertComment(commentRequest);
    }
}
