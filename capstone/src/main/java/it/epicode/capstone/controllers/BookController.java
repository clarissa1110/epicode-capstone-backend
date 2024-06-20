package it.epicode.capstone.controllers;

import it.epicode.capstone.models.Book;
import it.epicode.capstone.services.BookService;
import it.epicode.capstone.types.responses.CompleteGetBookResponseBody;
import it.epicode.capstone.types.responses.GetBookResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.awt.*;
import java.util.Arrays;
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

//    public List<CompleteGetBookResponseBody> getALlBooks(@RequestParam String q) {
//        return bookService.retrieveAllBooks(q);
//    }


}
