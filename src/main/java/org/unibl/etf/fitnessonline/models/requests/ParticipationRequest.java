package org.unibl.etf.fitnessonline.models.requests;

import lombok.Data;

import java.sql.Date;

@Data
public class ParticipationRequest {
    private String paymentMethod;
    private Date date;
    private Integer userId;
    private Integer programId;
}
