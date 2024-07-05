package it.epicode.capstone.controllers;

import it.epicode.capstone.models.Book;
import it.epicode.capstone.models.Bookshelf;
import it.epicode.capstone.models.User;
import it.epicode.capstone.services.BookService;
import it.epicode.capstone.services.BookshelfService;
import it.epicode.capstone.services.UserService;
import it.epicode.capstone.types.requests.UpdateUserRequestBody;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    @Autowired
    private BookshelfService bookshelfService;

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Page<User>> getUsers(@RequestParam(defaultValue = "0") int page,
                                              @RequestParam(defaultValue = "10") int size,
                                              @RequestParam(defaultValue = "id") String sortBy) {
        return new ResponseEntity<>(userService.retrieveAllUsers(page, size, sortBy), HttpStatus.OK) ;
    }

    @GetMapping("/{userId}")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public ResponseEntity<User> getUser(@PathVariable int userId) {
        return new ResponseEntity<>(userService.retrieveUserById(userId), HttpStatus.OK) ;
    }

    @PatchMapping("/{userId}")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public ResponseEntity<User> updateUser(@RequestBody @Validated UpdateUserRequestBody userRequestBody,
                                           @PathVariable int userId,
                                           BindingResult validation) throws BadRequestException {
        if(validation.hasErrors()){
            throw new BadRequestException(validation.getAllErrors()
                    .stream()
                    .map(objectError -> objectError.getDefaultMessage())
                    .reduce("", (acc, curr) -> acc+curr));
        }
        return new ResponseEntity<>(userService.editUser(userId, userRequestBody), HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteUser(@PathVariable int userId) {
        return userService.removeUser(userId);
    }

//    @GetMapping("/{userId}/bookshelves")
//    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
//    public ResponseEntity<List<Bookshelf>> getUserBookshelves(@PathVariable int userId) {
//        List<Bookshelf> bookshelves = bookshelfService.findBookshelfByUserId(userId);
//        return new ResponseEntity<>(bookshelves, HttpStatus.OK);
//    }

//    @PostMapping("/{userId}/bookshelves/{bookshelfId}/books/{bookId}")
//    public ResponseEntity<Bookshelf> addBookToBookshelf(@PathVariable int userId,
//                                                        @PathVariable int bookshelfId,
//                                                        @PathVariable int bookId) {
//        Book book = bookService.retrieveBookById(bookId);
//        userService.addBookToBookshelf(userId, bookshelfId, book);
//        return ResponseEntity.status(HttpStatus.OK).build();
//    }
}
