package it.epicode.capstone.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Bookshelf {

    @Id
    @GeneratedValue
    private int bookshelfId;

    private String name;

    @OneToMany(mappedBy = "bookshelf")
    private List<Book> bookList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    public void addBook(Book book) {
        bookList.add(book);
        book.setBookshelf(this);
    }

    public void removeBook(Book book) {
        bookList.remove(book);
        book.setBookshelf(null);
    }


}
