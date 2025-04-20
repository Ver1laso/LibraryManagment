package dev.jlprisan.LibraryManagment.Repository;

import dev.jlprisan.LibraryManagment.Entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
}
