package org.unibl.etf.fitnessonline.models.requests;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;

@Data
public class ProgramRequest {
    private String name;
    private String description;
    private String location;
    private String instructor;
    private String contact;
    private String video;
    private Date beginDate;
    private Date endDate;
    private BigDecimal price;
    private String difficulty;
    private Integer userId;
    private Integer categoryId;
}
