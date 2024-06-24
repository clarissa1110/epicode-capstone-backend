package it.epicode.capstone.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Column(length = 1000)
    private String title;

    @Column(length = 1000)
    private String subtitle;

    @Column(length = 500)
    private List<String> authors;

    @Column(length = 500)
    private String publisher;

    @Column(length = 10000)
    public String description;

    @Column(name = "published_date")
    private String publishedDate;
    private List<String> categories;
    private String thumbnail;

    @ManyToOne
    @JoinColumn(name = "bookshelf_id")
    @JsonIgnore
    private Bookshelf bookshelf;

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", id='" + id + '\'' +
                ", etag='" + etag + '\'' +
                ", title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", authors=" + authors +
                ", publisher='" + publisher + '\'' +
                ", description='" + description + '\'' +
                ", publishedDate='" + publishedDate + '\'' +
                ", categories=" + categories +
                ", thumbnail='" + thumbnail + '\'' +
                '}';
    }
}
