package com.adote.me.dtl.login;

public class LoginOutputDTO {

    private Long id;

    private String name;

    public LoginOutputDTO(Long id, String name) {
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
