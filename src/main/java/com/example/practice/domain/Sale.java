package com.example.practice.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Sale {
    @Id
    private long id;

    @OneToOne
    private User buyer;

    @OneToOne
    private Product product;

    private Date dateOfOperation;

}
