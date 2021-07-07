package com.example.practice.domain;

import javax.persistence.*;

@Entity
public class User {

    @Id
    private long id;

    private String username;

    @ManyToOne
    private Role role;

}
