package org.unibl.etf.fitnessonline.models.dtos;

import lombok.Data;

import java.sql.Date;

@Data
public class ProgramParticipationDTO {
    private Date date;
    private String paymentMethod;
}
