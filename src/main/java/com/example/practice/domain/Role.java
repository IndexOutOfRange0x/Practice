package com.example.practice.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Role {

    @Id
    private long id;

    private String roleName;


    @OneToMany(cascade = CascadeType.ALL)
    private List<User> users = new ArrayList<>();
}
