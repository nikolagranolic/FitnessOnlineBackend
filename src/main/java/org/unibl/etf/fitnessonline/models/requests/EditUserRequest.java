package org.unibl.etf.fitnessonline.models.requests;

import lombok.Data;

@Data
public class EditUserRequest {
    private String firstName;
    private String lastName;
    private String city;
    private String avatar;
    private String email;
    private String password;
}
