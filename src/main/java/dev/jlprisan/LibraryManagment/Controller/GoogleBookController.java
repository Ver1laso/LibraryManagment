package dev.jlprisan.LibraryManagment.Controller;

import dev.jlprisan.LibraryManagment.Service.GoogleBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
