package it.epicode.capstone.types.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateBookshelfRequestBody {

    @NotBlank(message = "bookshelf name field cannot be empty")
    private String name;
}
