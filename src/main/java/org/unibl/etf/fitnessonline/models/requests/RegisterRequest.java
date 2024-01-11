package org.unibl.etf.fitnessonline.models.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterRequest {
    @NotBlank
    @Size(max = 45)
    private String firstName;
    @NotBlank
    @Size(max = 45)
    private String lastName;
    @NotBlank
    @Size(max = 45)
    private String city;
    @NotBlank
    @Size(max = 45)
    private String username;
    @NotBlank
    private String password;
    private String avatar;
    @NotBlank
    @Size(max = 45)
    private String email;
}
