package it.epicode.capstone.types.requests;

import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class UpdateUserRequestBody {
    private String username;

    @Email(message = "email does not have the right format")
    private String email;

    private String password;

    private String firstName;

    private String lastName;

    private String avatarUrl;

    private String userRole;
}
