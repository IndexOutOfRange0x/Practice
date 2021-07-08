package com.example.practice.domain;

import javax.persistence.*;

@Entity
public class User {

    @Id
    private long id;

    private String userName;

    @ManyToOne
    private Role role;

}
