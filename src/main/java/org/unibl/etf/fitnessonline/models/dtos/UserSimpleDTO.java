package org.unibl.etf.fitnessonline.models.dtos;

import lombok.Data;

@Data
public class UserSimpleDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private String username;
    private String avatar;
}
