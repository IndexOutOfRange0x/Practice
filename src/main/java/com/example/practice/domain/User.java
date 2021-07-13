package com.example.practice.domain;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue
    private long Id;

    private String userName;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "role_id")
    private Role role;

    public User() {
    }

    public User(String userName) {
        this.userName = userName;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        this.Id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
