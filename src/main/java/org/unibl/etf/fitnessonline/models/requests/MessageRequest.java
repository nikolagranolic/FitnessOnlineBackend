package org.unibl.etf.fitnessonline.models.requests;

import lombok.Data;

@Data
public class MessageRequest {
    private String content;
    private Integer senderId;
    private Integer recipientId;
}
