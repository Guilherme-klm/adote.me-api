package com.adote.me.dtl.login;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginInputDTO {

    @JsonProperty("email")
    private String email;

    @JsonProperty("password")
    private String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
