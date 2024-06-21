package it.epicode.capstone.controllers;

import it.epicode.capstone.models.Bookshelf;
import it.epicode.capstone.models.User;
import it.epicode.capstone.services.BookshelfService;
import it.epicode.capstone.services.UserService;
import it.epicode.capstone.types.requests.CreateBookshelfRequestBody;
import it.epicode.capstone.types.requests.UpdateBookshelfRequestBody;
import it.epicode.capstone.types.requests.UpdateUserRequestBody;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookshelves")
public class BookshelfController {

    @Autowired
    private BookshelfService bookshelfService;

    @PostMapping
    public ResponseEntity<Bookshelf> createBookshelf(@RequestBody @Validated CreateBookshelfRequestBody bookshelfRequestBody, BindingResult validation) throws BadRequestException {
        if(validation.hasErrors()){
            throw new BadRequestException(validation.getAllErrors()
                    .stream()
                    .map(objectError -> objectError.getDefaultMessage())
                    .reduce("", (acc, curr) -> acc+curr));
        }
        return new ResponseEntity<>(bookshelfService.addBookshelf(bookshelfRequestBody), HttpStatus.CREATED);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Page<Bookshelf>> getBookshelves(@RequestParam(defaultValue = "0") int page,
                                                         @RequestParam(defaultValue = "10") int size,
                                                         @RequestParam(defaultValue = "id") String sortBy) {
        return new ResponseEntity<>(bookshelfService.retrieveAllBookshelves(page, size, sortBy), HttpStatus.OK) ;
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Bookshelf> getBookshelf(@PathVariable int bookshelfId) {
        return new ResponseEntity<>(bookshelfService.retrieveBookshelfById(bookshelfId), HttpStatus.OK) ;
    }

    @PatchMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Bookshelf> updateBookshelf(@RequestBody @Validated UpdateBookshelfRequestBody bookshelfRequestBody,
                                           @PathVariable int bookshelfId,
                                           BindingResult validation) throws BadRequestException {
        if(validation.hasErrors()){
            throw new BadRequestException(validation.getAllErrors()
                    .stream()
                    .map(objectError -> objectError.getDefaultMessage())
                    .reduce("", (acc, curr) -> acc+curr));
        }
        return new ResponseEntity<>(bookshelfService.editBookshelf(bookshelfId, bookshelfRequestBody), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteBookshelf(@PathVariable int bookshelfId) {
        return bookshelfService.removeBookshelf(bookshelfId);
    }

    @PostMapping("/{bookshelfId}/books/{bookId}")
    public ResponseEntity<Bookshelf> addBookToBookshelf(@PathVariable int bookshelfId, @PathVariable int bookId) {
        Bookshelf updatedBookshelf = bookshelfService.addBookToBookshelf(bookshelfId, bookId);
        return new ResponseEntity<>(updatedBookshelf, HttpStatus.OK);
    }

    @DeleteMapping("/{bookshelfId}/books/{bookId}")
    public ResponseEntity<Bookshelf> removeBookFromBookshelf(@PathVariable int bookshelfId, @PathVariable int bookId) {
        Bookshelf updatedBookshelf = bookshelfService.removeBookFromBookshelf(bookshelfId, bookId);
        return new ResponseEntity<>(updatedBookshelf, HttpStatus.OK);
    }
}
