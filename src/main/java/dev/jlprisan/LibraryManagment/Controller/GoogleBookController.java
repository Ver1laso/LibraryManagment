package dev.jlprisan.LibraryManagment.Controller;

import dev.jlprisan.LibraryManagment.Service.GoogleBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
public class GoogleBookController {

    private final GoogleBookService googleBookService;

    @Autowired
    public GoogleBookController(GoogleBookService googleBookService){
        this.googleBookService = googleBookService;
    }

    @GetMapping("/search")
    public ResponseEntity<String> search(@RequestParam String query){
        return ResponseEntity.ok(googleBookService.searchGoogleBooks(query));
    }

    @GetMapping("search/title")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<String> searchGoogleBookTitle(@RequestParam String title){
        return ResponseEntity.ok(googleBookService.searchGoogleBooksTitle(title));
    }

    @GetMapping("search/author")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<String> searchGoogleBookAuthor(@RequestParam String author){
        return ResponseEntity.ok(googleBookService.searchGoogleBooksAuthor(author));
    }

    @GetMapping("search/isbn")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<String> searchGoogleBooksISBN(@RequestParam String isbn){
        return ResponseEntity.ok(googleBookService.searchGoogleBooksISBN(isbn));
    }
}
