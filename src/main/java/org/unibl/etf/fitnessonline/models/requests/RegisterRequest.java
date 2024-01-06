package org.unibl.etf.fitnessonline.models.requests;

import lombok.Data;

@Data
public class RegisterRequest {
    private String firstName;
    private String lastName;
    private String city;
    private String username;
    private String password;
    private String avatar;
    private String email;
}
