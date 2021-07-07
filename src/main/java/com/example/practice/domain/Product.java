package com.example.practice.domain;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    private long id;

    private String name;

    private String description;

    private double price;


}
