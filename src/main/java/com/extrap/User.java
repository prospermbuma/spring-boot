package com.extrap;

public class User {
    private int id;
    private String name;
    private String email;

    // Constructor
    public User(String name, String email, int id) {
        this.name = name;
        this.email = email;
        this.id = id;
    }

    // Getters & setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
