package org.unibl.etf.fitnessonline.models.requests;

import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class FilterRequest {
    @Size(max = 45)
    private String name;
    @Size(max = 45)
    private String location;
    @Size(max = 45)
    private String description;
    public Integer categoryId;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;
}
