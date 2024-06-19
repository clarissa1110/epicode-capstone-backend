package it.epicode.capstone.services;

import it.epicode.capstone.exceptions.BookshelfNotFoundException;
import it.epicode.capstone.exceptions.UserNotFoundException;
import it.epicode.capstone.models.Bookshelf;
import it.epicode.capstone.models.User;
import it.epicode.capstone.repositories.BookshelfRepository;
import it.epicode.capstone.types.requests.CreateBookshelfRequestBody;
import it.epicode.capstone.types.requests.UpdateBookshelfRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class BookshelfService {

    @Autowired
    private BookshelfRepository bookshelfRepository;

    public Page<Bookshelf> retrieveAllBookshelves(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return bookshelfRepository.findAll(pageable);
    }

    public Bookshelf retrieveBookshelfById(int bookshelfId) {
        return bookshelfRepository.findById(bookshelfId).orElseThrow(() -> new BookshelfNotFoundException("Bookshelf not found with id: " + bookshelfId));
    }

    public Bookshelf addBookshelf(CreateBookshelfRequestBody bookshelfRequestBody) {
        Bookshelf bookshelfToCreate = new Bookshelf();

        bookshelfToCreate.setName(bookshelfRequestBody.getName());

        return bookshelfRepository.save(bookshelfToCreate);
    }

    public Bookshelf editBookshelf(int bookshelfId, UpdateBookshelfRequestBody bookshelfRequestBody) {
        Bookshelf bookshelfToUpdate = bookshelfRepository.findById(bookshelfId).orElseThrow(() -> new BookshelfNotFoundException("Bookshelf not found with id: " + bookshelfId));

        if (bookshelfRequestBody.getName() != null) {
            bookshelfToUpdate.setName(bookshelfRequestBody.getName());
        }

        return bookshelfRepository.save(bookshelfToUpdate);
    }

    public String removeBookshelf(int bookshelfId) {
        Bookshelf bookshelfToDelete = bookshelfRepository.findById(bookshelfId).orElseThrow(() -> new BookshelfNotFoundException("Bookshelf not found with id: " + bookshelfId));

        bookshelfRepository.delete(bookshelfToDelete);

        return "Bookshelf with id: " + bookshelfId + " successfully deleted";
    }
}
