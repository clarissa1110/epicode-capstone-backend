package it.epicode.capstone.types.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateUserRequestBody {
    @NotBlank(message = "username cannot be empty")
    private String username;

    @NotBlank(message = "email cannot be empty")
    @Email(message = "email does not have the right format")
    private String email;

    @NotBlank(message = "password cannot be empty")
    private String password;

    @NotBlank(message = "first name cannot be empty")
    private String firstName;

    @NotBlank(message = "last name cannot be empty")
    private String lastName;

    @NotBlank(message = "avatar url cannot be empty")
    private String avatarUrl;

    @NotBlank(message = "user must have a role")
    private String userRole;
}
