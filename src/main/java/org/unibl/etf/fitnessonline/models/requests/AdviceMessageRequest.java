package org.unibl.etf.fitnessonline.models.requests;

import lombok.Data;

@Data
public class AdviceMessageRequest {
    private Integer sender;
    private String content;
}
