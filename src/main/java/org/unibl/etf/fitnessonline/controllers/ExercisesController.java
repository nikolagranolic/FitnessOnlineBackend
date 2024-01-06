package org.unibl.etf.fitnessonline.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.unibl.etf.fitnessonline.models.dtos.ExerciseDTO;
import org.unibl.etf.fitnessonline.services.ExercisesService;

import java.util.List;

@RestController
@RequestMapping("/api/exercises")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class ExercisesController {
    private final ExercisesService service;
    @GetMapping("/{muscle}")
    public List<ExerciseDTO> getExercisesByMuscle(@PathVariable String muscle) {
        return service.getExercisesByMuscle(muscle);
    }

}
