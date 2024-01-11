package org.unibl.etf.fitnessonline.models.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AdviceMessageRequest {
    @NotNull(message = "Sender cannot be null")
    private Integer sender;

    @NotBlank(message = "Content cannot be blank")
    private String content;
}
