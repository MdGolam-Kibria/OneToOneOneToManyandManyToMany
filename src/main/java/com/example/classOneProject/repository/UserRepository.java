package com.example.classOneProject.repository;

import com.example.classOneProject.ForSpringSecurity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User,Long> {
    User findByUsernameAndIsActiveTrue(String username);
}
