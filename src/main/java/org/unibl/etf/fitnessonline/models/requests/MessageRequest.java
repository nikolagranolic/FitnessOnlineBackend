package org.unibl.etf.fitnessonline.models.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MessageRequest {
    @NotBlank
    private String content;
    @NotNull
    private Integer senderId;
    @NotNull
    private Integer recipientId;
}
