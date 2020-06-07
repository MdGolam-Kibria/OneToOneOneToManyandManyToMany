package com.example.classOneProject.repository;

import com.example.classOneProject.ForSpringSecurity.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
    int countByName(String name);

    Role findByName(String roleName);

}
