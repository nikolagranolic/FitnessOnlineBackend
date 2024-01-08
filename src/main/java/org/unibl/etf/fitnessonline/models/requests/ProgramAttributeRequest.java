package org.unibl.etf.fitnessonline.models.requests;

import lombok.Data;

@Data
public class ProgramAttributeRequest {
    private Integer programId;
    private Integer attributeId;
    private String value;
}
