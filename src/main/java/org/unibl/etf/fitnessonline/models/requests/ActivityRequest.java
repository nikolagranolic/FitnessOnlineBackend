package org.unibl.etf.fitnessonline.models.requests;

import lombok.Data;

import java.sql.Date;

@Data
public class ActivityRequest {
    private String exercise;
    private Integer duration;
    private String intensity;
    private Integer result;
    private Date date;
    private Integer userId;
}
