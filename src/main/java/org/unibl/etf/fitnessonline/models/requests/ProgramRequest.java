package org.unibl.etf.fitnessonline.models.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;

@Data
public class ProgramRequest {
    @NotBlank
    @Size(max = 45)
    private String name;
    @NotBlank
    private String description;
    @NotBlank
    @Size(max = 45)
    private String location;
    @NotBlank
    @Size(max = 45)
    private String instructor;
    @NotBlank
    @Size(max = 45)
    private String contact;
    private String video;
    @NotNull
    private Date beginDate;
    @NotNull
    private Date endDate;
    @NotNull
    private BigDecimal price;
    @NotBlank
    @Size(max = 45)
    private String difficulty;
    @NotNull
    private Integer userId;
    @NotNull
    private Integer categoryId;
}
