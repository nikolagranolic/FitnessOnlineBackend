package org.unibl.etf.fitnessonline.models.requests;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class FilterRequest {
    private String name;
    private String location;
    private String description;
    public Integer categoryId;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;
}
