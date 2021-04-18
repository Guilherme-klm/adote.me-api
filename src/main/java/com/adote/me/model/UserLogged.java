package com.adote.me.model;

public class UserLogged {

    private Long id;

    private String name;

    public UserLogged(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
