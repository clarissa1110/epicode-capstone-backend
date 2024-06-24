package it.epicode.capstone.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Bookshelf {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    @OneToMany(mappedBy = "bookshelf")
    private List<Book> bookList = new ArrayList<>();

    public void addBook(Book book) {
        bookList.add(book);
        book.setBookshelf(this);
    }

    public void removeBook(Book book) {
        bookList.remove(book);
        book.setBookshelf(null);
    }


}
