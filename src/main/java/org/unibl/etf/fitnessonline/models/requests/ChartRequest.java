package org.unibl.etf.fitnessonline.models.requests;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.sql.Date;

@Data
public class ChartRequest {
    @NotNull(message = "BeginDate cannot be null")
    private Date beginDate;
    @NotNull(message = "EndDate cannot be null")
    private Date endDate;
}
