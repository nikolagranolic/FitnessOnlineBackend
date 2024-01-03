package org.unibl.etf.fitnessonline.models.dtos;

import lombok.Data;

@Data
public class ProgramAttributeDTO {
    private Integer id;
    private String value;
    private AttributeDTO attribute;

}
