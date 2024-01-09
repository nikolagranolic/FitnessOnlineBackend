package org.unibl.etf.fitnessonline.models.requests;

import lombok.Data;

import java.sql.Date;

@Data
public class ChartRequest {
    private Date beginDate;
    private Date endDate;
}
