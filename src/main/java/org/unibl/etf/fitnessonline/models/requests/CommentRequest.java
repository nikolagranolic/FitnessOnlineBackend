package org.unibl.etf.fitnessonline.models.requests;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class CommentRequest {
    private String content;
    private Timestamp timestamp;
    private int userId;
    private int programId;
}
