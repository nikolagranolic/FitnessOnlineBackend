package org.unibl.etf.fitnessonline.models.dtos;

import lombok.Data;

import java.sql.Date;

@Data
public class ActivityDTO {
    private String exercise;
    private Integer duration;
    private String intensity;
    private Integer result;
    private Date date;
}
