package com.spring.ies.spring;


import java.util.ArrayList;

public class Movie {
    private String name;
    private int id;


    public Movie(int id, String name) {
        this.name = name;
        this.id=id;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
