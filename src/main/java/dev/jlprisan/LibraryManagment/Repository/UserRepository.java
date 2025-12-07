package dev.jlprisan.LibraryManagment.Repository;

import dev.jlprisan.LibraryManagment.Entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);
    boolean existsByEmail(String email);
}
