package Service;

import Entities.UserEntity;
import Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> findAll(){
        return userRepository.findAll();
    }

    public UserEntity save (UserEntity user){
        return userRepository.save(user);
    }
    public UserEntity findById(Long id){
        return userRepository.findById(id).orElse(null);
    }
}
