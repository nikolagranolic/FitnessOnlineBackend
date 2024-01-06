package org.unibl.etf.fitnessonline.services;

import org.unibl.etf.fitnessonline.models.dtos.ExerciseDTO;

import java.util.List;

public interface ExercisesService {
    List<ExerciseDTO> getExercisesByMuscle(String muscle);
}
