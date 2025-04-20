package Controller;

import Entities.UserEntity;
import Service.UserService;
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
    public UserEntity addUser(@RequestBody UserEntity user){
        return userService.save(user);
    }
}
