package it.epicode.capstone.types.responses;

import it.epicode.capstone.models.Bookshelf;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeleteBookshelfResponseBody {
    private String message;
    private Bookshelf bookshelf;
}
