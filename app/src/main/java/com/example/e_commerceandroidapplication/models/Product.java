package com.example.e_commerceandroidapplication.models;

import java.io.Serializable;

public class Product implements Serializable {
    public String name, image, description;
    public Integer quantity, price;

    public Product() {
    }

    public Product(String name, String image, String description, Integer quantity, Integer price) {
        this.name = name;
        this.image = image;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }

}
