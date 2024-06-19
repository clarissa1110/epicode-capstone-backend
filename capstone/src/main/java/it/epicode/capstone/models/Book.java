package it.epicode.capstone.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Book {

    @Id
    private String id;
    private String etag;
    private String title;
    private String subtitle;
    private List<String> authors;
    private String publisher;
    public String description;

    @Column(name = "published_date")
    private String publishedDate;
    private List<String> categories;
    private String thumbnail;
}
