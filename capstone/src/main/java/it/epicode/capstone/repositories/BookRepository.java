package it.epicode.capstone.repositories;

import it.epicode.capstone.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findBookByBookshelf_bookshelfId(int bookshelfId);
}
