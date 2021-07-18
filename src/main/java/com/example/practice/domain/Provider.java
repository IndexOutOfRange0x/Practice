package com.example.practice.domain;

import javax.persistence.*;

@Entity
public class Provider {
    @Id
    @GeneratedValue
    private long id;

    private String nameOfOrganization;

    @OneToOne
    private Product product;

    private double discount;

    public Provider() {
    }

    public Provider(long id, String nameOfOrganization, Product product, double discount) {
        this.id = id;
        this.nameOfOrganization = nameOfOrganization;
        this.product = product;
        this.discount = discount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameOfOrganization() {
        return nameOfOrganization;
    }

    public void setNameOfOrganization(String nameOfOrganization) {
        this.nameOfOrganization = nameOfOrganization;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
