package dev.jlprisan.LibraryManagment.Repository;


import dev.jlprisan.LibraryManagment.Entities.BookShelvesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<BookShelvesEntity, Long> {
}
