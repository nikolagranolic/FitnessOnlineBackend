package org.unibl.etf.fitnessonline.models.requests;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class CommentRequest {
    @NotNull(message = "Content cannot be null")
    private String content;
    private Timestamp timestamp;
    @NotNull(message = "UserId cannot be null")
    private int userId;
    @NotNull(message = "ProgramId cannot be null")
    private int programId;
}
