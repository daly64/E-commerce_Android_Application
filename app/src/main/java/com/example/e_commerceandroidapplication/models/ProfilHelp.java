package com.example.e_commerceandroidapplication.models;

import java.io.Serializable;

public class ProfilHelp implements Serializable {
    public String name, image;

    public ProfilHelp() {
    }

    public ProfilHelp(String name, String image) {
        this.name = name;
        this.image = image;
    }
}