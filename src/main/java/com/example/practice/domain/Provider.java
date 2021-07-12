package com.example.practice.domain;

import javax.persistence.*;

@Entity
public class Provider {
    @Id
    private long id;

    private String nameOfOrganization;

    @OneToOne
    private Product product;

    private double discount;
}
