package org.unibl.etf.fitnessonline.models.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.sql.Date;

@Data
public class ParticipationRequest {
    @NotBlank
    @Size(max = 45)
    private String paymentMethod;
    @NotNull
    private Date date;
    @NotNull
    private Integer userId;
    @NotNull
    private Integer programId;
}
