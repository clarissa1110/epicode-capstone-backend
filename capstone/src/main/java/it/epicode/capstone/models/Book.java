package it.epicode.capstone.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.Check;

import java.util.List;

@Data
@Entity
public class Book {

    @Id
    @GeneratedValue
    private int bookId;

    @Column(length = 500)
    private String id;

    @Column(length = 500)
    private String etag;

    @Column(length = 100)
    private String title;

    @Column(length = 100)
    private String subtitle;

    @Column(length = 500)
    private List<String> authors;

    @Column(length = 500)
    private String publisher;

    @Column(length = 2000)
    public String description;

    @Column(name = "published_date")
    private String publishedDate;
    private List<String> categories;
    private String thumbnail;

    @ManyToOne
    @JoinColumn(name = "bookshelf_id")
    private Bookshelf bookshelf;
}
