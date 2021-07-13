package com.example.practice.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Sale {
    @Id
    private long Id;

    @OneToOne
    private User buyer;

    @OneToOne
    private Product product;

    private Date dateOfOperation;

    public Sale() {
    }

    public Sale(long id, User buyer, Product product, Date dateOfOperation) {
        Id = id;
        this.buyer = buyer;
        this.product = product;
        this.dateOfOperation = dateOfOperation;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Date getDateOfOperation() {
        return dateOfOperation;
    }

    public void setDateOfOperation(Date dateOfOperation) {
        this.dateOfOperation = dateOfOperation;
    }
}
