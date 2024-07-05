package it.epicode.capstone.controllers;

import it.epicode.capstone.models.Book;
import it.epicode.capstone.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @Value("${books.apiKey}")
    private String apiKey;

    @GetMapping(value = "/api/books", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Book> retrieveAllBooks(@RequestParam String q) {
      return bookService.retrieveAllBooks(q);
    }

    @GetMapping("api/books/{bookId}")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public ResponseEntity<Book> getBook(@PathVariable int bookId) {
        return new ResponseEntity<>(bookService.retrieveBookById(bookId), HttpStatus.OK);
    }

}
