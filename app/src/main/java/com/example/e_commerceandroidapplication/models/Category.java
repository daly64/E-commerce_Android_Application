package com.example.e_commerceandroidapplication.models;

import java.io.Serializable;
import java.util.List;

public class Category implements Serializable {
    public String name, image;
    public List<Product> items;
    public Integer items_number;

    public Category() {
    }

    public Category(String name, String image, Integer items_number) {
        this.name = name;
        this.image = image;
        this.items_number = items_number;
    }
}
