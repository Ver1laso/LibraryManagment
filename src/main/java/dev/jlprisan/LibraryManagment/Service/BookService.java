package dev.jlprisan.LibraryManagment.Service;

import dev.jlprisan.LibraryManagment.Entities.BookEntity;
import dev.jlprisan.LibraryManagment.Entities.UserEntity;
import dev.jlprisan.LibraryManagment.Repository.BookRepository;
import dev.jlprisan.LibraryManagment.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    public BookService (BookRepository bookRepository, UserRepository userRepository){
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    public List<BookEntity> findAllBooks() {
        return bookRepository.findAll();
    }

    public BookEntity findBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public BookEntity save(BookEntity book) {
        return bookRepository.save(book);
    }

    public void deleteByID(Long id){
        bookRepository.deleteById(id);
    }

//    public BookEntity borrowBook(Long bookId, Long userId){
//        BookEntity book = findBookById(bookId);
//        UserEntity user = userRepository.findById(userId).orElse(null);
//
//        if(book != null && !book.isBorrowed() && user != null){
//            book.setBorrowedTo(user);
//            book.setBorrowed(true);
//            return save(book);
//        }
//
//        // if book not found
//        return null;
//    }

    public BookEntity returnBook(Long bookId){
        BookEntity book =findBookById(bookId);
        if(book != null && book.isBorrowed()){
            book.setBorrowed(false);
            book.setBorrowedTo(null);
            return save(book);
        }
        //TODO handle error if book not found or book not borrowed
        return null;
    }
}
