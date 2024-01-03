package org.unibl.etf.fitnessonline.models.dtos;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ProgramSimpleDTO {
    private Integer id;
    private String name;
    private List<ImageDTO> images;
    private BigDecimal price;
}
