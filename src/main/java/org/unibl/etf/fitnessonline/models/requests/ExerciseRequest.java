package org.unibl.etf.fitnessonline.models.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ExerciseRequest {
    @NotBlank
    private String muscle;
}
