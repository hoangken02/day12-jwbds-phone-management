package com.codeGym.model;

import javax.persistence.*;

@Entity
@Table(name = "smartphone")
public class Smartphone {
@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
private String producer;
private String model;
private String price;

    public Smartphone() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Smartphone(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return producer+": "+model+" with price "+price;
    }
}
