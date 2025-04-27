package dev.jlprisan.LibraryManagment.Service;

import dev.jlprisan.LibraryManagment.Credentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Service
public class GoogleBookService {

    private final RestTemplate restTemplate;
    private final Credentials credentials;

    @Autowired
    public GoogleBookService(RestTemplate restTemplate, Credentials credentials){
        this.restTemplate = restTemplate;
        this.credentials = credentials;
    }




    public String searchGoogleBooks(String query){
        String url = "https://www.googleapis.com/books/v1/volumes?q="
                + query + "&key=" + credentials.getApiKey();

        return restTemplate.getForObject(url, String.class);
    }
}
