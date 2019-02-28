package com.example.drynl.ikmpd.Model;

import java.io.Serializable;

/**
 * Created by drynl on 6-12-2016.
 */

public class Gebruiker implements Serializable {

    private String naam;
    private String password;

    public Gebruiker(String naam, String password) {
        this.naam = naam;
        this.password = password;
    }

    public String getNaam() {
        return naam;
    }

    public String getPassword() {
        return password;
    }
}
