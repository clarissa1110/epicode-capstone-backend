package it.epicode.capstone.types.responses;

import lombok.Data;

import java.util.UUID;

@Data
public class GetUserResponseBody {
    private int id;

    private String username;

    private String email;

    private String firstName;

    private String lastName;

    private String avatarUrl;
}
