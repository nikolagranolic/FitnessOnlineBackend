package org.unibl.etf.fitnessonline.models.dtos;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class CommentDTO {
    private Integer id;
    private String content;
    private Timestamp datetime;
    private UserSimpleDTO user;
}
