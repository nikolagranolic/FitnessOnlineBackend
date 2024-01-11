package org.unibl.etf.fitnessonline.models.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProgramAttributeRequest {
    @NotNull
    private Integer programId;
    @NotNull
    private Integer attributeId;
    @NotBlank
    @Size(max = 45)
    private String value;
}
