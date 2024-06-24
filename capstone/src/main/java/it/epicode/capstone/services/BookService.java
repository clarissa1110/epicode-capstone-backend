package it.epicode.capstone.services;

import it.epicode.capstone.exceptions.BookNotFoundException;
import it.epicode.capstone.models.Book;
import it.epicode.capstone.repositories.BookRepository;
import it.epicode.capstone.types.responses.CompleteGetBookResponseBody;
import it.epicode.capstone.types.responses.GetBookResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Value("${books.apiKey}")
    private String apiKey;

    private RestTemplate restTemplate;

    public List<Book> retrieveAllBooks(String q) {
        String url = "https://www.googleapis.com/books/v1/volumes?q=" + q + "&key=" + apiKey;

        RestTemplate restTemplate = new RestTemplate();

        GetBookResponseBody response = restTemplate.getForObject(url, GetBookResponseBody.class);

        if (response != null && response.getItems() != null) {
            List<Book> books = Arrays.stream(response.getItems())
                    .map(this::mapJsonToBook)
                    .collect(Collectors.toList());
            return bookRepository.saveAll(books);
        }
        else {
            throw new BookNotFoundException("Book not found");
        }
    }

    public Book retrieveBookById(int bookId) {
        return bookRepository.findById(bookId).orElseThrow(() -> new BookNotFoundException("Book not found with id: " + bookId));
    }

    private Book mapJsonToBook(GetBookResponseBody.BookResponse bookResponse) {
        Book book = new Book();

        book.setId(bookResponse.getId());
        book.setEtag(bookResponse.getEtag());
        book.setTitle(bookResponse.getVolumeInfo().getTitle());
        book.setSubtitle(bookResponse.getVolumeInfo().getSubtitle());
        book.setAuthors(bookResponse.getVolumeInfo().getAuthors());
        book.setPublisher(bookResponse.getVolumeInfo().getPublisher());
        book.setPublishedDate(bookResponse.getVolumeInfo().getPublishedDate());
        book.setDescription(bookResponse.getVolumeInfo().getDescription());
        book.setCategories(bookResponse.getVolumeInfo().getCategories());
        book.setThumbnail(bookResponse.getVolumeInfo().getImageLinks().getThumbnail());

        return book;
    }
}
