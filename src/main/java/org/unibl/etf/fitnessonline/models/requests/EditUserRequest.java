package org.unibl.etf.fitnessonline.models.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EditUserRequest {
    @NotBlank
    @Size(max = 45, message = "First name length must be at most 45 characters")
    private String firstName;
    @NotBlank
    @Size(max = 45, message = "Last name length must be at most 45 characters")
    private String lastName;
    @NotBlank
    @Size(max = 45, message = "City length must be at most 45 characters")
    private String city;

    private String avatar;
    @NotBlank
    @Size(max = 45, message = "Email length must be at most 45 characters")
    private String email;
    @Size(max = 100, message = "Password length must be at most 100 characters")
    private String password;
}
