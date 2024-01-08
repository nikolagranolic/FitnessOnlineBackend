package org.unibl.etf.fitnessonline.models.dtos;

import lombok.Data;

@Data
public class MessageDTO {
    private String content;
    private UserSimpleDTO sender;
}
