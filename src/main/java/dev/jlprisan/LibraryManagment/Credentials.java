package dev.jlprisan.LibraryManagment;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DBCredentials {

    @Value("${db.username")
    private String username;

    @Value("${db.password")
    private String password;

//    @PostConstruct
//    public void showCredentials(){
//        System.out.println("Usuario: " + username);
//        System.out.println("Password: " + password);
//    }
}
