package Service;

import Entities.BookEntity;
import Entities.UserEntity;
import Repository.BookRepository;
import Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

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

    public BookEntity borrowBook(Long bookId, Long userId){
        BookEntity book = findBookById(bookId);
        UserEntity user = userRepository.findById(userId).orElse(null);

        if(book != null && !book.isBorrowed() && user != null){
            book.setBorrowedBy(user);
            book.setBorrowed(true);
            return save(book);
        }

        // if book not found
        return null;
    }

    public BookEntity returnBook(Long bookId){
        BookEntity book =findBookById(bookId);
        if(book != null && book.isBorrowed()){
            book.setBorrowed(false);
            book.setBorrowedBy(null);
            return save(book);
        }
        //TODO handle error if book not found or book not borrowed
        return null;
    }
}
