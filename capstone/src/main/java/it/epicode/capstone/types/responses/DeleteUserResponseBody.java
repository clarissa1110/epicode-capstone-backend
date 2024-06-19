package it.epicode.capstone.types.responses;

import it.epicode.capstone.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeleteUserResponseBody {
    private String message;
    private User user;
}
