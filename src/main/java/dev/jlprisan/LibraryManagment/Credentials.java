package dev.jlprisan.LibraryManagment;



import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Credentials {

    @Value("${db.username}")
    private String username;

    @Value("${db.password}")
    private String password;

    @Value("${google.books.api.key}")
    private String googleBooksApiKey;

//    @PostConstruct
//    public void showCredentials(){
//        System.out.println("Usuario: " + username);
//        System.out.println("Password: " + password);
//        System.out.println("Api Key: " + googleBooksApiKey);
//    }


    public String getApiKey() {
        return googleBooksApiKey;
    }
}
