package dev.jlprisan.LibraryManagment.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import dev.jlprisan.LibraryManagment.Credentials;
import dev.jlprisan.LibraryManagment.DTO.GoogleBookResponseDTO;
import dev.jlprisan.LibraryManagment.DTO.ItemsDTO;
import dev.jlprisan.LibraryManagment.Entities.BookEntity;
import dev.jlprisan.LibraryManagment.Mapper.BookMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class GoogleBookService {

    private final RestTemplate restTemplate;
    private final Credentials credentials;
    private final BookMapper bookMapper;


    public GoogleBookService(RestTemplate restTemplate, Credentials credentials, BookMapper bookMapper){
        this.restTemplate = restTemplate;
        this.credentials = credentials;
        this.bookMapper = bookMapper;
    }


    public String searchGoogleBooks(String query){
        String url = "https://www.googleapis.com/books/v1/volumes?q="
                + query + "&key=" + credentials.getApiKey();

        return restTemplate.getForObject(url, String.class);
    }

    public GoogleBookResponseDTO searchGoogleBooksTitle(String title, String langRestrict){
//        String url = "https://www.googleapis.com/books/v1/volumes?q=intitle:"
//                + title + "&key=" + credentials.getApiKey();

        String url = "https://www.googleapis.com/books/v1/volumes?q=intitle:"
                + title;

        if(langRestrict != null && !langRestrict.isEmpty()) {
            url += "&langRestrict=" + langRestrict;
        }

        url += "&maxResults=20";

        url += "&key=" + credentials.getApiKey();


        GoogleBookResponseDTO response = restTemplate.getForObject(url, GoogleBookResponseDTO.class);

        System.out.println("=== DEBUG INFO ===");
        System.out.println("Total items reportado: " + response.getTotalItems());
        System.out.println("Items recibidos: " + response.getItems().size());

        // Ver los primeros títulos
        response.getItems().stream()
                .limit(5)
                .forEach(item ->
                        System.out.println("Título: " + item.getVolumeInfo().getTitle())
                );
        System.out.println("=== FIN DEBUG ===");




        List<ItemsDTO> filteredItems = response.getItems().stream()
                .filter(item -> item.getVolumeInfo().getTitle() != null)
//                .filter(item -> item.getVolumeInfo().getTitle().toLowerCase().contains(title))
                .collect(Collectors.toList());
        response.setItems(filteredItems);
//        List<BookEntity> mappedBooks = bookMapper.toBookEntity(response);
//        System.out.println("Libros mapeados: " + mappedBooks);
//        System.out.println("Cantidad de libros encontrados: " + mappedBooks.size());

        System.out.println("Google API raw items: " + response.getItems().size());
        
        return response;

    }

    public GoogleBookResponseDTO searchGoogleBooksAuthor(String author){
        String url = "https://www.googleapis.com/books/v1/volumes?q=inauthor:"
                + author + "&key=" + credentials.getApiKey();

        GoogleBookResponseDTO response = restTemplate.getForObject(url, GoogleBookResponseDTO.class);

        List<ItemsDTO> filteredItems = response.getItems().stream()
                .filter(item -> item.getVolumeInfo().getAuthors() != null)
                .filter(item-> item.getVolumeInfo().getAuthors().contains(author))
                .collect(Collectors.toList());
        response.setItems(filteredItems);
//        List<BookEntity> mappedBooks = bookMapper.toBookEntity(response);
//        System.out.println("Libros mapeados: " + mappedBooks);
//        System.out.println("Cantidad de libros encontrados: " + mappedBooks.size());

        return response;
    }


    public GoogleBookResponseDTO searchGoogleBooksISBN(String isbn) throws JsonProcessingException {
        String url = "https://www.googleapis.com/books/v1/volumes?q=isbn:"
                + isbn + "&key=" + credentials.getApiKey();

        GoogleBookResponseDTO response = restTemplate.getForObject(url, GoogleBookResponseDTO.class);

        List<BookEntity> mappedBooks = bookMapper.toBookEntity(response);
        System.out.println("Libros mapeados: " + mappedBooks);

        return response;

    }


}
