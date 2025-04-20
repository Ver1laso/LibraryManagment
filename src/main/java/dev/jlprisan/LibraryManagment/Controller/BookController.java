package dev.jlprisan.LibraryManagment.Controller;

import dev.jlprisan.LibraryManagment.Entities.BookEntity;
import dev.jlprisan.LibraryManagment.Entities.UserEntity;
import dev.jlprisan.LibraryManagment.Service.BookService;
import dev.jlprisan.LibraryManagment.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {


    private final BookService bookService;
    private final UserService userService;

    public BookController(BookService bookService, UserService userService){
        this.bookService = bookService;
        this.userService = userService;
    }

    @GetMapping
    public List<BookEntity> getAllBooks(){
        return bookService.findAllBooks();
    }

    @GetMapping("/{id}")
    public BookEntity getBook(@PathVariable Long id){
        return bookService.findBookById(id);
    }

    @PostMapping()
    public BookEntity addBook(@RequestBody BookEntity book){
        return bookService.save(book);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookEntity> updateBook(@PathVariable Long id, @RequestBody BookEntity book){
        Optional<BookEntity> existingBook = Optional.ofNullable(bookService.findBookById(id));
        if(existingBook.isPresent()){
            book.setId(id);
            BookEntity updateBook = bookService.save(book);
            return ResponseEntity.ok(updateBook);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id){
        bookService.deleteByID(id);
    }

    @PostMapping("/{bookId}/borrow/{userId}")
    public ResponseEntity<BookEntity> borrowBook(@PathVariable Long bookId, @PathVariable Long userId){
//        BookEntity borrowedBook = bookService.borrowBook(bookId, userId);
//        if(borrowedBook != null){
//            return ResponseEntity.ok(borrowedBook);
//        } else {
//            return ResponseEntity.badRequest().build();
//        }
        Optional<BookEntity> book = Optional.ofNullable(bookService.findBookById(bookId));
        Optional<UserEntity> user = Optional.ofNullable(userService.findById(userId));

        if(!book.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        if(!user.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        BookEntity borrowedBook = bookService.borrowBook(bookId,userId);
        return ResponseEntity.ok(borrowedBook);
    }

    @PostMapping("/{bookId}/return")
    public ResponseEntity<BookEntity> returnBook(@PathVariable Long bookId){
        BookEntity returnedBook = bookService.returnBook(bookId);
        if(returnedBook != null){
            return ResponseEntity.ok(returnedBook);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

}
