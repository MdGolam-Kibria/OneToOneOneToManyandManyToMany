package com.example.classOneProject.ForSpringSecurity.model;

import com.example.classOneProject.dto.BaseModel;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.List;
@Data
@Entity
public class User extends BaseModel {
    private String name;
    private String email;
    @NaturalId
    private String username;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role" , joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    @ToString.Exclude
    private List<Role> roles;
}
