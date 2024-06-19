package it.epicode.capstone.repositories;

import it.epicode.capstone.models.Bookshelf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookshelfRepository extends JpaRepository<Bookshelf, Integer> {
}
