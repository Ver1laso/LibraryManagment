package dev.jlprisan.LibraryManagment.Controller;

import dev.jlprisan.LibraryManagment.Entities.UserEntity;
import dev.jlprisan.LibraryManagment.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public List<UserEntity> getallUsers(){
        return userService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserEntity addUser(@RequestBody UserEntity user){
        return userService.save(user);
    }
}
