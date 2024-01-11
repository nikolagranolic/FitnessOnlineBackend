package org.unibl.etf.fitnessonline.models.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.sql.Date;

@Data
public class ActivityRequest {
    @NotBlank(message = "Exercise cannot be blank")
    @Size(max = 45, message = "Exercise length must be at most 45 characters")
    private String exercise;
    @NotNull(message = "Duration cannot be null")
    private Integer duration;
    @NotBlank(message = "Intensity cannot be blank")
    @Size(max = 45, message = "Intensity length must be at most 45 characters")
    private String intensity;
    @NotNull(message = "Result cannot be null")
    private Integer result;
    @NotNull(message = "Date cannot be null")
    private Date date;
    @NotNull(message = "UserId cannot be null")
    private Integer userId;
}
